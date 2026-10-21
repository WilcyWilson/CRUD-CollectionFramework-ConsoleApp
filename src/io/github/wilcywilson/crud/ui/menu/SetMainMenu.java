package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.enums.Menu;
import io.github.wilcywilson.crud.ui.menu.enums.SetMenuChoice;
import io.github.wilcywilson.crud.infrastructure.engine.HashMapStorageEngine;
import io.github.wilcywilson.crud.infrastructure.engine.LinkedHashMapStorageEngine;
import io.github.wilcywilson.crud.ui.UiText;

import java.io.PrintStream;
import java.util.Scanner;


public class SetMainMenu extends AbstractMenu<SetMenuChoice> {
    public SetMainMenu(Scanner scanner, PrintStream out, String additionalInfo) {
        super(scanner, out, Menu.SET_STORAGE_ENGINE, SetMenuChoice.class, UiText.BACK_TO_MAIN.getMessage(), LoopStatus.CONTINUE, additionalInfo);
    }

    @Override
    protected Operations createOperation(SetMenuChoice setMenuChoice) {
        return switch (setMenuChoice) {
            case HASH_SET -> new HashMapStorageEngine(setMenuChoice.getDisplayName());
            case LINKED_HASH_SET -> new LinkedHashMapStorageEngine(setMenuChoice.getDisplayName());
            case TREE_SET -> new LinkedHashMapStorageEngine(setMenuChoice.getDisplayName());
        };
    }
}



