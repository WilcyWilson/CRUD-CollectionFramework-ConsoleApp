package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.crudlogic.*;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.interfaces.CrudOperations;
import io.github.wilcywilson.crud.utils.InputUtil;

import java.util.Scanner;

public class Entry {
    private static final String MAIN_MENU = """
            ------ Main Menu ------
            1.List
            2.HashSet
            3.HashMap
            0.Exit
            
            """;

    public static void chooseCollectionFramework() {
        try (var scanner = new Scanner(System.in)) {
            CrudOperations crudChoice;
            do {
                System.out.print(MenuCreator.createMenu(MainMenuChoice.EXIT));
//                System.out.print(MAIN_MENU);
                int input = InputUtil.prompt(scanner, "Enter Your Choice : ", Integer::parseInt);
                crudChoice = selectCrud(input);
                System.out.println();
                crudChoice.crudMainLoop(scanner);
            } while (!(crudChoice instanceof ExitCrud));
        }
    }

    private static CrudOperations selectCrud(int input) {
        MainMenuChoice userMainMenuChoice = MainMenuChoice.choiceFromInteger(input).orElse(MainMenuChoice.UNKNOWN);

        return switch (userMainMenuChoice) {
            case UNKNOWN -> new UnknownCrud();
            case EXIT -> new ExitCrud();
            case LIST -> new ListCrud();
            case HASHMAP -> new HashMapCrud();
            case HASHSET -> new HashSetCrud();
        };
    }
}
