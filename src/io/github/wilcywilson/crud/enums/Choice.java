package io.github.wilcywilson.crud.enums;

public enum Choice {
    LIST(1),
    HASHSET(2),
    HASHMAP(3);

    private final int value;

    Choice(int value) {
        this.value = value;
    }

    public static Choice fromInteger(int input) {
        for (Choice choice : Choice.values()) {
            if (choice.value == input) {
                return choice;
            }
        }
        return null;
    }
}
