package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.domain.enums.StandardMenuChoice;
import io.github.wilcywilson.crud.shared.menu.MenuChoice;
import io.github.wilcywilson.crud.shared.menu.MenuChoiceUtil;
import io.github.wilcywilson.crud.shared.menu.Operations;
import io.github.wilcywilson.crud.ui.ConsolePrompt;
import io.github.wilcywilson.crud.ui.MenuCreator;
import io.github.wilcywilson.crud.ui.UiText;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public abstract class AbstractMenu<T extends Enum<T> & MenuChoice> implements Operations {
    protected final Scanner scanner;
    protected final PrintStream out;
    private final Menu menuType;
    private final Class<T> enumClass;
    private final String exitMessage;
    private final LoopStatus exitStatus;
    private final String[] additionalInfos;

    protected AbstractMenu(Scanner scanner, PrintStream out, Menu menuType, Class<T> enumClass, String exitMessage, LoopStatus exitStatus, String... additionalInfos) {
        this.scanner = scanner;
        this.out = out;
        this.menuType = menuType;
        this.enumClass = enumClass;
        this.exitMessage = exitMessage;
        this.exitStatus = exitStatus;
        this.additionalInfos = additionalInfos;
    }

    @Override
    public LoopStatus run() {
        while (true) {
            MenuCreator.createMenu(out, menuType, additionalInfos);

            int input = ConsolePrompt.prompt(scanner, out, UiText.ENTER_YOUR_CHOICE.getMessage(), Integer::parseInt);

            if (input == StandardMenuChoice.EXIT.getCode()) {
                out.println(exitMessage);
                return exitStatus;
            }

            Optional<T> menuChoice = MenuChoiceUtil.fromCode(enumClass, input);

            if (menuChoice.isEmpty()) {
                out.println(UiText.INVALID_SELECTION.getMessage());
                continue;
            }

            Operations operation = createOperation(menuChoice.orElseThrow());

            if (operation.run() == LoopStatus.EXIT) {
                return LoopStatus.EXIT;
            }
        }
    }

    protected abstract Operations createOperation(T menuChoice);
}
