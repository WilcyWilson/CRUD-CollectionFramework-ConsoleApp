package io.github.wilcywilson.crud;

import io.github.wilcywilson.crud.crudlogic.HashMapCrud;
import io.github.wilcywilson.crud.crudlogic.HashSetCrud;
import io.github.wilcywilson.crud.crudlogic.ListCrud;
import io.github.wilcywilson.crud.crudlogic.UnknownCrud;
import io.github.wilcywilson.crud.enums.MainMenuChoice;
import io.github.wilcywilson.crud.interfaces.CrudOperations;

import java.util.Scanner;

public class CollectionCrudApp {
    private static final String MAIN_MENU = """
            1.List
            2.HashSet
            3.HashMap
            Enter Your Choice : \
            """;

    private static void chooseCollectionFramework() {


        try (var scanner = new Scanner(System.in)) {
            CrudOperations crudChoice;
            do {
                System.out.print(MAIN_MENU);
                crudChoice = scanner.hasNextInt() ? selectCrud(scanner.nextInt()) : new UnknownCrud();
                System.out.println();
                crudChoice.crudLoop(scanner);
//                scanner.nextLine(); // Clear leftover newline characters before reading anything else
            } while(!(crudChoice instanceof UnknownCrud));
        }
    }

    private static CrudOperations selectCrud(int input) {
        MainMenuChoice userMainMenuChoice = MainMenuChoice.choiceFromInteger(input).orElse(MainMenuChoice.UNKNOWN);

        return switch (userMainMenuChoice) {
            case UNKNOWN -> new UnknownCrud();
            case LIST -> new ListCrud();
            case HASHMAP -> new HashMapCrud();
            case HASHSET -> new HashSetCrud();
        };
    }

    public static void main(String[] args) {
        chooseCollectionFramework();
    }
}
