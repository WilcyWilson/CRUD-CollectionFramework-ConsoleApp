package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.interfaces.MainOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class ExitMain implements MainOperations {
    @Override
    public void storageEngineLoop(Scanner scanner, PrintStream out) {
        out.println("Exiting.....");
    }
}
