package io.github.wilcywilson.crud.ui;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Function;

public enum ConsolePrompt {
    ;

    public static <T> T prompt(Scanner scanner, PrintStream out, String prompt, Function<String, T> parser) {
        while (true) {
            out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return parser.apply(line);
            } catch (NumberFormatException e) {
                out.println(UiText.INVALID_INPUT.getMessage());
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}
