package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.util.Scanner;

public class LinkedListStorageEngine implements ListOperations {

    private final String additionalInfo;

    public LinkedListStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void dataSchemaLoop(Scanner scanner) {

    }
}
