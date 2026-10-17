package io.github.wilcywilson.crud.ui;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Function;

public class InputUtil {
    private InputUtil() {
    }

    public static <T> T prompt(Scanner scanner, PrintStream out, String prompt, Function<String, T> parser) {
        while (true) {
            out.println();
            out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                out.println();
                return parser.apply(line);
            } catch (RuntimeException e) {
                out.println(UiText.INVALID_INPUT.getMessage());
            }
        }
    }
}
