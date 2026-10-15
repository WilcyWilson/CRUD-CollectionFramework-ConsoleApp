package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuChoice;

import java.util.Optional;

public enum MainMenuChoice implements MenuChoice {
    LIST(1, "List"),
    SET(2, "Set"),
    QUEUE(3, "Queue"),
    MAP(4, "Map"),
    UNKNOWN(-1, "Unknown"),
    EXIT(0, "Exit");

    private final int value;
    private final String name;

    MainMenuChoice(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Optional<MainMenuChoice> choiceFromInteger(int input) {
        for (MainMenuChoice mainMenuChoice : MainMenuChoice.values()) {
            if (mainMenuChoice.value == input) {
                return Optional.of(mainMenuChoice);
            }
        }
        return Optional.empty();
    }

    @Override
    public int getValue() {
        return value;
    }


    public String getName() {
        return name;
    }
}
