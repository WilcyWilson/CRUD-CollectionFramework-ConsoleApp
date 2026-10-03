package io.github.wilcywilson.crud.utils;

import java.util.Scanner;
import java.util.function.Function;

public class InputUtil {
    private InputUtil() {
    }

    public static <T> T prompt(Scanner scanner, String prompt, Function<String, T> parser) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return parser.apply(line);
            } catch (RuntimeException e) {
                System.out.println("\nInvalid Input. Please try again\n");
            }
        }
    }
}
