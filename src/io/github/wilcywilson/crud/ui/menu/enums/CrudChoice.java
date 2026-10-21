package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

public enum CrudChoice implements MenuChoice {
    INSERT(1, "Insert"),
    DISPLAY(2, "Display"),
    SEARCH(3, "Search"),
    DELETE(4, "Delete"),
    UPDATE(5, "Update");

    private final int value;
    private final String name;

    CrudChoice(int value, String name) {
        this.value = value;
        this.name = name();
    }

    @Override
    public int getCode() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

}
