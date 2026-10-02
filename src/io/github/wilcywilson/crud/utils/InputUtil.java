package io.github.wilcywilson.crud.utils;

import java.util.Scanner;

public class InputUtil {
    private InputUtil() {
    }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.\n");
            }
        }
    }
}
