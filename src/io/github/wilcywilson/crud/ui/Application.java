package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.MainMenuChoice;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.shared.interfaces.Operations;
import io.github.wilcywilson.crud.ui.menu.HashMapMain;
import io.github.wilcywilson.crud.ui.menu.HashSetMain;
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
            int input = InputUtil.prompt(scanner, out, UiText.ENTER_YOUR_CHOICE.getMessage(), Integer::parseInt);
            MainMenuChoice mainMenuChoice = MainMenuChoice
                    .choiceFromInteger(input)
                    .orElse(MainMenuChoice.UNKNOWN);

            if (mainMenuChoice == MainMenuChoice.EXIT) {
                out.println(UiText.EXITING.getMessage());
                return;
            }

            if (mainMenuChoice == MainMenuChoice.UNKNOWN) {
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
            case LIST -> new ListMain(mainMenuChoice.getName());
            case MAP -> new HashMapMain();
            case QUEUE -> new QueueMain();
            case SET -> new HashSetMain();
            default -> throw new IllegalArgumentException("Unreachable" + mainMenuChoice);
        };
    }
}
