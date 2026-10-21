package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.ui.menu.enums.ListMenuChoice;
import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.enums.Menu;
import io.github.wilcywilson.crud.infrastructure.engine.*;
import io.github.wilcywilson.crud.ui.UiText;

import java.io.PrintStream;
import java.util.Scanner;

public class ListMainMenu extends AbstractMenu<ListMenuChoice> {

    public ListMainMenu(Scanner scanner, PrintStream out, String additionalInfo) {
        super(scanner, out, Menu.LIST_STORAGE_ENGINE, ListMenuChoice.class, UiText.BACK_TO_MAIN.getMessage(),LoopStatus.CONTINUE, additionalInfo);
    }

    @Override
    protected Operations createOperation(ListMenuChoice listMenuChoice) {
        return switch (listMenuChoice) {
            case ARRAYLIST -> new ArrayListStorageEngine(listMenuChoice.getDisplayName());
            case LINKED_LIST -> new LinkedListStorageEngine(listMenuChoice.getDisplayName());
        };
    }
}
