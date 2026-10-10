package io.github.wilcywilson.crud.model;

import java.io.Serial;

public class InvalidValueException extends TableException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidValueException(String message) {
        super(message);
    }
}
