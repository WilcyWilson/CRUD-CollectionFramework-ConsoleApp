package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.interfaces.MenuChoice;

import java.util.Optional;

public enum MapMenuChoice implements MenuChoice {
    HASHMAP(1, "HashMap"),
    LINKED_HASHMAP(2, "LinkedHashMap"),
    TREEMAP(3,"TREEMAP"),
    EXIT(0,"Exit"),
    INVALID_SELECTION(-1, "Invalid Selection");

    private final int value;
    private final String name;

    MapMenuChoice(int value, String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public int getCode() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return name;
    }
}
