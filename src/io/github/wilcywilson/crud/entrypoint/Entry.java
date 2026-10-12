package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.crudlogic.*;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.interfaces.MainOperations;
import io.github.wilcywilson.crud.utils.InputUtil;

import java.util.Scanner;

public class Entry {

    public static void chooseCollectionFramework() {
        try (var scanner = new Scanner(System.in)) {
            MainOperations mainChoice;
            do {
                MenuCreator.createMenu(Menu.MAIN);
                int input = InputUtil.prompt(scanner, "Enter Your Choice : ", Integer::parseInt);
                mainChoice = selectMain(input);
                mainChoice.storageEngineLoop(scanner);
            } while (!(mainChoice instanceof ExitMain));
        }
    }

    private static MainOperations selectMain(int input) {
        MainMenuChoice userMainMenuChoice = MainMenuChoice.choiceFromInteger(input).orElse(MainMenuChoice.UNKNOWN);

        return switch (userMainMenuChoice) {
            case UNKNOWN -> new UnknownMain();
            case EXIT -> new ExitMain();
            case LIST -> new ListMain(userMainMenuChoice.name());
            case MAP -> new HashMapMain();
            case QUEUE -> new QueueMain();
            case SET -> new HashSetMain();
        };
    }
}
