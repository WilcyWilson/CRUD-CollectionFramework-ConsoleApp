package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.CrudOperations;

import java.util.Scanner;

public class UnknownCrud implements CrudOperations {
    @Override
    public void crudLoop(Scanner scanner) {
        System.out.println("Invalid Selection. Please choose correct 1, 2 or 3");
    }
}
