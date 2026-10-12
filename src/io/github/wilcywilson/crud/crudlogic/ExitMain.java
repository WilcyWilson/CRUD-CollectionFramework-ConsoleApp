package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.MainOperations;

import java.util.Scanner;

public class ExitMain implements MainOperations {
    @Override
    public void storageEngineLoop(Scanner scanner) {
        System.out.println("Exiting.....");
    }
}
