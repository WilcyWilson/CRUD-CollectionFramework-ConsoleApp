package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuChoice;

public enum CrudChoice implements MenuChoice {
    INSERT(1),
    DISPLAY(2),
    SEARCH(3),
    DELETE(4),
    UPDATE(5),
    EXIT(0);

    private final int value;

    CrudChoice(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}
