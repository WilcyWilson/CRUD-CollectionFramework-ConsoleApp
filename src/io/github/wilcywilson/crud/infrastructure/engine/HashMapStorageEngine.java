package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.shared.menu.MapOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class HashMapStorageEngine implements MapOperations {
    private final String additionalInfo;

    public HashMapStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        return null;
    }
}
