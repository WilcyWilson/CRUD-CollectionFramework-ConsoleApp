package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.enums.LoopStatus;
import io.github.wilcywilson.crud.interfaces.MainOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class QueueMain implements MainOperations {
    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        return LoopStatus.EXIT;
    }
}
