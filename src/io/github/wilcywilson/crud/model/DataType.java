package io.github.wilcywilson.crud.model;

import java.util.function.Function;

public enum DataType {
    INTEGER("int", Integer.class, Integer::parseInt),
    STRING("String", String.class, text -> text),
    BOOLEAN("Boolean", Boolean.class, Boolean::parseBoolean);

    private final String label;
    private final Class<?> javaType;
    private final Function<String, Object> parser;

    DataType(String label, Class<?> javaType, Function<String, Object> parser) {
        this.label = label;
        this.javaType = javaType;
        this.parser = parser;
    }

    public String label() {
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


