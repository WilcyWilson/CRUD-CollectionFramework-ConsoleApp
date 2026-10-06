package io.github.wilcywilson.crud.utils;

import java.util.Scanner;
import java.util.function.Function;

public class InputUtil {
    private InputUtil() {
    }

    public static <T> T prompt(Scanner scanner, String prompt, Function<String, T> parser) {
        System.out.println();
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                System.out.println();
                return parser.apply(line);
            } catch (RuntimeException e) {
                System.out.println("Invalid Input. Please try again");
            }
        }
    }
}
