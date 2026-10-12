package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.util.Scanner;

public class ExitStorageEngine implements ListOperations {
    @Override
    public void dataSchemaLoop(Scanner scanner) {
        System.out.println("Back to Main Menu.....");
    }
}
