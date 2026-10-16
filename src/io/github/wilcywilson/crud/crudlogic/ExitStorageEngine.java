package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.enums.UiText;
import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class ExitStorageEngine implements ListOperations {
    @Override
    public void dataSchemaLoop(Scanner scanner, PrintStream out) {
        out.println(UiText.BACK_TO_MAIN.getMessage());
    }
}
