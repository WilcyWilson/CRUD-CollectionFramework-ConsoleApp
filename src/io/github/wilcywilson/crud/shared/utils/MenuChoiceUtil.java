package io.github.wilcywilson.crud.shared.utils;

import io.github.wilcywilson.crud.shared.interfaces.MenuChoice;

import java.util.Optional;

public enum MenuChoiceUtil {
    ;

    public static <T extends Enum<T> & MenuChoice> Optional<T> fromCode(Class<T> enumClass, int input) {
        for (T choice : enumClass.getEnumConstants()) {
            if (choice.getCode() == input) {
                return Optional.of(choice);
            }
        }
        return Optional.empty();
    }
}
