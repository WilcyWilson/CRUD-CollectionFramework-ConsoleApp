package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.enums.UiText;
import io.github.wilcywilson.crud.interfaces.ListOperations;

import java.io.PrintStream;
import java.util.Scanner;

public class UnknownStorageEngine implements ListOperations {
    @Override
    public void dataSchemaLoop(Scanner scanner, PrintStream out) {
        out.println(UiText.INVALID_SELECTION.getMessage());
    }
}
