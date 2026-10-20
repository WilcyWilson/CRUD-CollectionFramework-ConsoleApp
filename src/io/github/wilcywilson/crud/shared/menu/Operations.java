package io.github.wilcywilson.crud.shared.menu;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;

import java.io.PrintStream;
import java.util.Scanner;

public sealed interface Operations permits MainOperations, MapOperations, ListOperations {
    LoopStatus run(Scanner scanner, PrintStream out);
}
