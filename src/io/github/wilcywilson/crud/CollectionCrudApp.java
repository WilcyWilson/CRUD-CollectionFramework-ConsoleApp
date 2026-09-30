package io.github.wilcywilson.crud;

import io.github.wilcywilson.crud.crudlogic.HashMapCrud;
import io.github.wilcywilson.crud.crudlogic.HashSetCrud;
import io.github.wilcywilson.crud.crudlogic.ListCrud;
import io.github.wilcywilson.crud.crudlogic.UnknownCrud;
import io.github.wilcywilson.crud.enums.Choice;
import io.github.wilcywilson.crud.interfaces.CrudOperations;

import java.util.Scanner;

public class CollectionCrudApp {

    public static void main(String[] args) {
        chooseCollectionFramework();
    }

    public static void chooseCollectionFramework() {
        String mainMenu = """
                1.List
                2.HashSet
                3.HashMap
                Enter Your Choice : \
                """;
        System.out.print(mainMenu);

        try (var scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                Choice userChoice = Choice.fromInteger(input).orElse(Choice.UNKNOWN);

                CrudOperations crudChoice = switch (userChoice) {
                    case LIST -> {
                        System.out.println();
                        yield new ListCrud();
                    }
                    case HASHSET -> {
                        System.out.println();
                        yield new HashSetCrud();
                    }
                    case HASHMAP -> {
                        System.out.println();
                        yield new HashMapCrud();
                    }
                    case UNKNOWN -> {
                        System.out.println();
                        yield new UnknownCrud();
                    }
                };
                crudChoice.crudLoop(scanner);
            } else {
                System.out.println();
                System.out.println("Please enter a valid option");
            }
        }
    }
}
