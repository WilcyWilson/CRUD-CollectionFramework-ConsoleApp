package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.crudlogic.*;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.interfaces.CrudOperations;
import io.github.wilcywilson.crud.utils.InputUtil;

import java.util.Scanner;

public class Entry {

    public static void chooseCollectionFramework() {
        try (var scanner = new Scanner(System.in)) {
            CrudOperations crudChoice;
            do {
                MenuCreator.createMenu(Menu.MAIN);
                int input = InputUtil.prompt(scanner, "Enter Your Choice : ", Integer::parseInt);
                crudChoice = selectCrud(input);
                crudChoice.crudMainLoop(scanner);
            } while (!(crudChoice instanceof ExitCrud));
        }
    }

    private static CrudOperations selectCrud(int input) {
        MainMenuChoice userMainMenuChoice = MainMenuChoice.choiceFromInteger(input).orElse(MainMenuChoice.UNKNOWN);

        return switch (userMainMenuChoice) {
            case UNKNOWN -> new UnknownCrud();
            case EXIT -> new ExitCrud();
            case LIST -> new ListCrud(userMainMenuChoice.name());
            case MAP -> new HashMapCrud();
            case QUEUE -> new QueueCrud();
            case SET -> new HashSetCrud();
        };
    }
}
