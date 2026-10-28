package io.github.wilcywilson.crud.domain.model;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

public enum DataType implements MenuChoice {
    INTEGER(1, "int"),
    STRING(2, "String"),
    BOOLEAN(3, "Boolean");

    private final int code;
    private final String displayName;

    DataType(int code, String displayName) {
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


