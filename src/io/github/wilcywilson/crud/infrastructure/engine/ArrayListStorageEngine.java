package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.shared.interfaces.ListOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class ArrayListStorageEngine implements ListOperations {
    private String additionalInfo;

    public ArrayListStorageEngine() {
        additionalInfo = "";
    }

    public ArrayListStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run(Scanner scanner, PrintStream out) {
        return LoopStatus.EXIT;
    }

    @Override
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
