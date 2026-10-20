package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.MapMenuChoice;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.infrastructure.engine.HashMapStorageEngine;
import io.github.wilcywilson.crud.infrastructure.engine.LinkedHashMapStorageEngine;
import io.github.wilcywilson.crud.infrastructure.engine.TreeMapStorageEngine;
import io.github.wilcywilson.crud.shared.menu.Operations;
import io.github.wilcywilson.crud.ui.UiText;

import java.io.PrintStream;
import java.util.Scanner;

public class MapMainMenu extends AbstractMenu<MapMenuChoice> {

    public MapMainMenu(Scanner scanner, PrintStream out, String additionalInfo) {
        super(scanner, out, Menu.MAP_STORAGE_ENGINE, MapMenuChoice.class, UiText.BACK_TO_MAIN.getMessage(), LoopStatus.CONTINUE, additionalInfo);
    }

    @Override
    protected Operations createOperation(MapMenuChoice mapMenuChoice) {
        return switch (mapMenuChoice) {
            case HASHMAP -> new HashMapStorageEngine(mapMenuChoice.getDisplayName());
            case LINKED_HASHMAP -> new LinkedHashMapStorageEngine(mapMenuChoice.getDisplayName());
            case TREEMAP -> new TreeMapStorageEngine(mapMenuChoice.getDisplayName());
        };
    }
}