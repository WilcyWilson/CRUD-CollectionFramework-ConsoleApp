package io.github.wilcywilson.crud.crudlogic;

import io.github.wilcywilson.crud.enums.UiText;
import io.github.wilcywilson.crud.interfaces.Operations;

import java.io.PrintStream;
import java.util.Scanner;

public class InvalidSelection implements Operations {
    @Override
    public void run(Scanner scanner, PrintStream out) {
        out.println(UiText.INVALID_SELECTION.getMessage());
    }
}
