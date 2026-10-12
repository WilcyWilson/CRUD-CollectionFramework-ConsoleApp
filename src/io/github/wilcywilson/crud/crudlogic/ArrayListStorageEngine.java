package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.util.Scanner;

public class ArrayListStorageEngine implements ListOperations {
    private final String additionalInfo;

    public ArrayListStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void dataSchemaLoop(Scanner scanner) {

    }
}
