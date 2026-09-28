package io.github.wilcywilson.crud.enums;

import java.util.Optional;

public enum Choice {
    UNKNOWN(0),
    LIST(1),
    HASHSET(2),
    HASHMAP(3);


    private final int value;

    Choice(int value) {
        this.value = value;
    }

    public static Optional<Choice> fromInteger(int input) {
        for (Choice choice : Choice.values()) {
            if (choice.value == input) {
                return Optional.of(choice);
            }
        }
        return Optional.empty();
    }
}
