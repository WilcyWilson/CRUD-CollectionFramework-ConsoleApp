package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.MainOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class UnknownMain implements MainOperations {
    @Override
    public void storageEngineLoop(Scanner scanner, PrintStream out) {
        out.println("Invalid Selection. Please choose a correct option from the menu");
    }
}
