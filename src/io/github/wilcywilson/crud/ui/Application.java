package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.crudlogic.*;
import io.github.wilcywilson.crud.enums.LoopStatus;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.interfaces.Operations;

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
            MainMenuChoice mainMenuChoice = MainMenuChoice.choiceFromInteger(input).orElse(MainMenuChoice.UNKNOWN);

            if (mainMenuChoice == MainMenuChoice.EXIT){
                out.println(UiText.EXITING.getMessage());
                return;
            }

            if (mainMenuChoice == MainMenuChoice.UNKNOWN){
                out.println(UiText.INVALID_SELECTION.getMessage());
                continue;
            }

            String mainMenuChoiceName = mainMenuChoice.getName();

            Operations mainOperations = switch (mainMenuChoice) {
                case LIST -> new ListMain(mainMenuChoiceName);
                case MAP -> new HashMapMain();
                case QUEUE -> new QueueMain();
                case SET -> new HashSetMain();
                default -> throw new IllegalArgumentException("Unreachable" + mainMenuChoice);
            };

            if (mainOperations.run(scanner, out) == LoopStatus.EXIT) {
                return;
            }
        }
    }
}
