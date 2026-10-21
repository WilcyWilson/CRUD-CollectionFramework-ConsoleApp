package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

public enum MainMenuChoice implements MenuChoice {
    LIST(1, "List"),
    SET(2, "Set"),
    QUEUE(3, "Queue"),
    MAP(4, "Map");

    private final int code;
    private final String displayName;

    MainMenuChoice(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }
}
