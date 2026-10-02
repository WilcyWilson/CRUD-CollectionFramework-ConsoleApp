package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.CrudOperations;

import java.util.Scanner;

public class ExitCrud implements CrudOperations {
    @Override
    public void crudMainLoop(Scanner scanner) {
        System.out.println("Exiting.....");
    }
}
