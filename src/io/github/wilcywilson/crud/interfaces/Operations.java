package io.github.wilcywilson.crud.interfaces;

import io.github.wilcywilson.crud.enums.LoopStatus;

import java.io.PrintStream;
import java.util.Scanner;

public interface Operations {
    LoopStatus run(Scanner scanner, PrintStream out);
}
