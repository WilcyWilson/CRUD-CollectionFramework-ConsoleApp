package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.MainMenuChoice;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.shared.menu.Operations;
import io.github.wilcywilson.crud.shared.menu.MenuChoiceUtil;
import io.github.wilcywilson.crud.ui.menu.MapMain;
import io.github.wilcywilson.crud.ui.menu.SetMain;
import io.github.wilcywilson.crud.ui.menu.ListMain;
import io.github.wilcywilson.crud.ui.menu.QueueMain;

import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    private final Scanner scanner;
    private final PrintStream out;

    public Application(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    public void run() {
        while (true) {
            MenuCreator.createMenu(out, Menu.MAIN);
            int input = ConsolePrompt.prompt(scanner, out, UiText.ENTER_YOUR_CHOICE.getMessage(), Integer::parseInt);

            MainMenuChoice mainMenuChoice = MenuChoiceUtil.fromCode(MainMenuChoice.class, input)
                                                          .orElse(MainMenuChoice.INVALID_SELECTION);

            if (mainMenuChoice == MainMenuChoice.EXIT) {
                out.println(UiText.EXITING.getMessage());
                return;
            }

            if (mainMenuChoice == MainMenuChoice.INVALID_SELECTION) {
                out.println(UiText.INVALID_SELECTION.getMessage());
                continue;
            }

            Operations mainOperations = createMainOperation(mainMenuChoice);

            if (mainOperations.run(scanner, out) == LoopStatus.EXIT) {
                return;
            }
        }
    }

    private Operations createMainOperation(MainMenuChoice mainMenuChoice) {
        return switch (mainMenuChoice) {
            case LIST -> new ListMain(mainMenuChoice.getDisplayName());
            case MAP -> new MapMain();
            case QUEUE -> new QueueMain();
            case SET -> new SetMain();
            default -> throw new IllegalArgumentException("Unreachable" + mainMenuChoice);
        };
    }
}
