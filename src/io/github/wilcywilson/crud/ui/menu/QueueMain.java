package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.shared.interfaces.MainOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class QueueMain implements MainOperations {
    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        return LoopStatus.EXIT;
    }
}
