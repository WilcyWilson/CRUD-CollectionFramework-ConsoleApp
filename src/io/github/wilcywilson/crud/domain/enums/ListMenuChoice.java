package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.menu.MenuChoice;

public enum ListMenuChoice implements MenuChoice {
    ARRAYLIST(1, "ArrayList"),
    LINKED_LIST(2, "Linked List"),
    INVALID_SELECTION(-1, "Invalid Selection"),
    EXIT(0, "Exit");

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
