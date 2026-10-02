package io.github.wilcywilson.crud.enums;

import java.util.Optional;

public enum MainMenuChoice {
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
}
