package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuOperations;

import java.util.Optional;

public enum MainMenuChoice implements MenuOperations {
    UNKNOWN(-1),
    EXIT(0),
    LIST(1),
    HASHSET(2),
    HASHMAP(3);

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
    public String retrieveTitle(String additionalInfo) {
        return "Main Menu" + additionalInfo;
    }

    @Override
    public String retrieveOptions() {
        StringBuilder menuNames = new StringBuilder();
        for (MainMenuChoice mainMenuChoice : MainMenuChoice.values()) {
            menuNames.append(mainMenuChoice.value).append(".").append(mainMenuChoice.name()).append("\n");
        }
        return menuNames.toString();
    }
}
