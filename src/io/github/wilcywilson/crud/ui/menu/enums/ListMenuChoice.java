package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

public enum ListMenuChoice implements MenuChoice {
    ARRAYLIST(1, "ArrayList"),
    LINKED_LIST(2, "Linked List");

    private final int code;
    private final String displayName;

    ListMenuChoice(int code, String displayName) {
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
