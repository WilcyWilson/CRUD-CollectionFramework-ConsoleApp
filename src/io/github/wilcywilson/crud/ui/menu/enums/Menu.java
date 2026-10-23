package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;
import io.github.wilcywilson.crud.ui.UiText;
import io.github.wilcywilson.crud.ui.menu.Titled;

public enum Menu implements Titled {
    MAIN(UiText.CHOOSE_STORAGE_TYPE.getMessage(), MainMenuChoice.values()),
    LIST_STORAGE_ENGINE(UiText.CHOOSE_STORAGE_ENGINE.getMessage(), ListMenuChoice.values()),
    MAP_STORAGE_ENGINE(UiText.CHOOSE_STORAGE_ENGINE.getMessage(), MapMenuChoice.values()),
    QUEUE_STORAGE_ENGINE(UiText.CHOOSE_STORAGE_ENGINE.getMessage(), QueueMenuChoice.values()),
    SET_STORAGE_ENGINE(UiText.CHOOSE_STORAGE_ENGINE.getMessage(), SetMenuChoice.values());

    private final String title;
    private final MenuChoice[] choices;

    Menu(String title, MenuChoice[] choices) {
        this.title = title;
        this.choices = choices;
    }

    @Override
    public String getBaseTitle() {
        return title;
    }

    public MenuChoice[] getChoices() {
        return choices;
    }

}
