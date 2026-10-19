package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.shared.menu.ListOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class LinkedListStorageEngine implements ListOperations {

    private final String additionalInfo;

    public LinkedListStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        return LoopStatus.EXIT;
    }
}
