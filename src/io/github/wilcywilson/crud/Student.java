package io.github.wilcywilson.crud;

import io.github.wilcywilson.crud.crudlogic.HashMapCrud;
import io.github.wilcywilson.crud.crudlogic.HashSetCrud;
import io.github.wilcywilson.crud.crudlogic.ListCrud;
import io.github.wilcywilson.crud.enums.Choice;

import java.util.Scanner;

public class Student {

    static void main() {
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
                Choice userChoice = Choice.fromInteger(input);

                switch (userChoice) {
                    case LIST -> {
                        System.out.println();
                        ListCrud.crudLoop();
                    }
                    case HASHSET -> {
                        System.out.println();
                        HashSetCrud.crudLoop();
                    }
                    case HASHMAP -> {
                        System.out.println();
                        HashMapCrud.crudLoop();
                    }
                    case null -> System.out.println("Invalid Selection. Please choose correct 1, 2 or 3");
                }
            } else System.out.println("Please enter a valid option");
        }
    }
}
