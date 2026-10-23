package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.ui.menu.AbstractDataSchema;
import io.github.wilcywilson.crud.ui.menu.enums.BlankMenuChoice;
import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.enums.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public class ArrayListStorageEngine extends AbstractDataSchema {

    public ArrayListStorageEngine(Scanner scanner, PrintStream out, String additionalInfo) {
        super(scanner, out, Menu.DEFINE_DATA_SCHEMA, additionalInfo);
    }
}
