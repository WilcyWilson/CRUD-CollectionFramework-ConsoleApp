package io.github.wilcywilson.crud.interfaces;

import java.io.PrintStream;
import java.util.Scanner;

public interface ListOperations extends Operations {
    void run(Scanner scanner, PrintStream out);
}
