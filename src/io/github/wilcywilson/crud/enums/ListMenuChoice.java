package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuChoice;

import java.util.Optional;

public enum ListMenuChoice implements MenuChoice {
    ARRAYLIST(1),
    LINKED_LIST(2),
    UNKNOWN(-1),
    EXIT(0);

    private final int value;

    ListMenuChoice(int value) {
        this.value = value;
    }

    public static Optional<ListMenuChoice> choiceFromInteger(int input) {
        for (ListMenuChoice listMenuChoice : ListMenuChoice.values()) {
            if (listMenuChoice.value == input) {
                return Optional.of(listMenuChoice);
            }
        }
        return Optional.empty();
    }

    @Override
    public int getValue() {
        return value;
    }
}
