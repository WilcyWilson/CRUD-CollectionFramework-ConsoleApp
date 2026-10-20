package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.menu.MenuChoice;

public enum StandardMenuChoice implements MenuChoice {
    EXIT(0, "Exit");

    private final int code;
    private final String displayName;

    StandardMenuChoice(int code, String displayName) {
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
