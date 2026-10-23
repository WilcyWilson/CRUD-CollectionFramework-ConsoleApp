package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.UiText;
import io.github.wilcywilson.crud.ui.menu.Titled;

public enum Wizard implements Titled {
    DEFINE_STORAGE_SCHEMA(UiText.DEFINE_DATA_SCHEMA.getMessage());

    private final String title;

    Wizard(String title) {
        this.title = title;
    }

    @Override
    public String getBaseTitle() {
        return title;
    }
}
