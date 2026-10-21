package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

public enum MapMenuChoice implements MenuChoice {
    HASHMAP(1, "HashMap"),
    LINKED_HASHMAP(2, "LinkedHashMap"),
    TREEMAP(3, "TreeMap");

    private final int code;
    private final String displayName;

    MapMenuChoice(int code, String name) {
        this.code = code;
        this.displayName = name;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
