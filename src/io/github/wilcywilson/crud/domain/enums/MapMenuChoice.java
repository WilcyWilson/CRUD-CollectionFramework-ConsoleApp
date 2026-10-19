package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.menu.MenuChoice;

public enum MapMenuChoice implements MenuChoice {
    HASHMAP(1, "HashMap"),
    LINKED_HASHMAP(2, "LinkedHashMap"),
    TREEMAP(3, "TreeMap"),
    EXIT(0, "Exit"),
    INVALID_SELECTION(-1, "Invalid Selection");

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
