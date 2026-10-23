package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

public enum BlankMenuChoice implements MenuChoice {
    ;

    private final int code;
    private final String displayName;

    BlankMenuChoice(int code, String displayName) {
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
