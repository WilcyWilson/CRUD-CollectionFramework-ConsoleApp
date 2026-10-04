package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.CrudOperations;

import java.util.Scanner;

public class UnknownCrud implements CrudOperations {
    @Override
    public void crudMainLoop(Scanner scanner) {
        System.out.println("Invalid Selection. Please choose a correct option from the menu\n");
    }
}
