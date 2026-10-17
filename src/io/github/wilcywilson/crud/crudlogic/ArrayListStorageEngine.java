package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.enums.LoopStatus;
import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class ArrayListStorageEngine implements ListOperations {
    private final String additionalInfo;

    public ArrayListStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        return LoopStatus.EXIT;
    }
}
