package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.crudlogic.*;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.enums.UiText;
import io.github.wilcywilson.crud.interfaces.Operations;
import io.github.wilcywilson.crud.utils.InputUtil;

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

            String mainMenuChoiceName = mainMenuChoice.getName();

            Operations mainOperations = switch (mainMenuChoice) {
                case UNKNOWN -> new InvalidSelection();
                case EXIT -> new Exit();
                case LIST -> new ListMain(mainMenuChoiceName);
                case MAP -> new HashMapMain();
                case QUEUE -> new QueueMain();
                case SET -> new HashSetMain();
            };

            mainOperations.run(scanner, out);

            if (mainOperations instanceof Exit) {
                break;
            }
        }
    }
}
