package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuChoice;

import java.util.Optional;

public enum ListMenuChoice implements MenuChoice {
    ARRAYLIST(1, "ArrayList"),
    LINKED_LIST(2, "Linked List"),
    UNKNOWN(-1, "Unknown"),
    EXIT(0, "Exit");

    private final int value;
    private final String name;

    ListMenuChoice(int value, String name) {
        this.value = value;
        this.name = name;
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

    @Override
    public String getName() {
        return name;
    }
}
