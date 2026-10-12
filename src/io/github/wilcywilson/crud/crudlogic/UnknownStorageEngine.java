package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.util.Scanner;

public class UnknownStorageEngine implements ListOperations {
    @Override
    public void dataSchemaLoop(Scanner scanner) {
        System.out.println("Invalid Selection. Please choose a correct option from the menu");
    }
}
