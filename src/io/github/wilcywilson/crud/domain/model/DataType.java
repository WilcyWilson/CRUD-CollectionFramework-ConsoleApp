package io.github.wilcywilson.crud.domain.model;

import io.github.wilcywilson.crud.domain.exception.InvalidValueException;

import java.util.function.Function;

public enum DataType {
    INTEGER(1,"int", Integer.class, Integer::parseInt),
    STRING(2,"String", String.class, text -> text),
    BOOLEAN(3,"Boolean", Boolean.class, Boolean::parseBoolean);

    private final int code;
    private final String label;
    private final Class<?> javaType;
    private final Function<String, Object> parser;

    DataType(int code, String label, Class<?> javaType, Function<String, Object> parser) {
        this.code = code;
        this.label = label;
        this.javaType = javaType;
        this.parser = parser;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public Object parse(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new InvalidValueException("A value is required.");
        }
        String text = raw.strip();
        try {
            return parser.apply(text);
        } catch (RuntimeException e) {
            throw new InvalidValueException("'" + text + "' is not a valid " + label + ".");
        }
    }

    public boolean accepts(Object value) {
        return javaType.isInstance(value);
    }

}


