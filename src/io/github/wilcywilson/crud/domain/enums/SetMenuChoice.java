package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.menu.MenuChoice;

public enum SetMenuChoice implements MenuChoice {
    HASH_SET(1, "HashSet"),
    LINKED_HASH_SET(2, "LinkedHashSet"),
    TREE_SET(3, "TreeSet");

    private final int code;
    private final String displayName;

    SetMenuChoice(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
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
