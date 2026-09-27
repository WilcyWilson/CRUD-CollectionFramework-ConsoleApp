package io.github.wilcywilson.crud;

import io.github.wilcywilson.crud.crudlogic.HashMapCrud;
import io.github.wilcywilson.crud.crudlogic.HashSetCrud;
import io.github.wilcywilson.crud.crudlogic.ListCrud;
import io.github.wilcywilson.crud.enums.Choice;

import java.util.Scanner;

public class Student {

    static void main(String[] args) {
        chooseCollectionFramework();
    }

    public static void chooseCollectionFramework() {

        System.out.println("1.List");
        System.out.println("2.HashSet");
        System.out.println("3.HashMap");
        System.out.println("Enter Your Choice : ");

        try (var scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                Choice userChoice = Choice.fromInteger(input);

                if (userChoice != null) {
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
                    }
                } else {
                    System.out.println("Invalid Selection. Please choose correct 1, 2 or 3");
                }
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }
}
