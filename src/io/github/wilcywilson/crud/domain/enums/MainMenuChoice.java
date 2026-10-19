package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.menu.MenuChoice;

import java.util.Optional;

public enum MainMenuChoice implements MenuChoice {
    LIST(1, "List"),
    SET(2, "Set"),
    QUEUE(3, "Queue"),
    MAP(4, "Map"),
    INVALID_SELECTION(-1, "Invalid Selection"),
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
    public int getCode() {
        return value;
    }


    public String getDisplayName() {
        return name;
    }
}
