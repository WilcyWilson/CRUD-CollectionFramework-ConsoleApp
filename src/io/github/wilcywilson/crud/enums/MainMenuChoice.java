package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuChoice;

import java.util.Optional;

public enum MainMenuChoice implements MenuChoice {
    LIST(1),
    SET(2),
    QUEUE(3),
    MAP(4),
    UNKNOWN(-1),
    EXIT(0);

    private final int value;

    MainMenuChoice(int value) {
        this.value = value;
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
}
