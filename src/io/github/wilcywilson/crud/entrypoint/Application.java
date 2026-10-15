package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.crudlogic.*;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.interfaces.MainOperations;
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
            int input = InputUtil.prompt(scanner, out, "Enter Your Choice : ", Integer::parseInt);
            MainMenuChoice userMainMenuChoice = MainMenuChoice.choiceFromInteger(input).orElse(MainMenuChoice.UNKNOWN);

            MainOperations op = switch (userMainMenuChoice) {
                case UNKNOWN -> new UnknownMain();
                case EXIT -> new ExitMain();
                case LIST -> new ListMain(userMainMenuChoice.name());
                case MAP -> new HashMapMain();
                case QUEUE -> new QueueMain();
                case SET -> new HashSetMain();
            };

            op.storageEngineLoop(scanner, out);

            if (op instanceof ExitMain) {
                break;
            }
        }
    }
}
