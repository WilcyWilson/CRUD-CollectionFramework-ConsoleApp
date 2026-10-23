package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;
import io.github.wilcywilson.crud.ui.UiText;

public enum Menu {
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

    public String getTitle(String... additionalInfos) {
        StringBuilder info = new StringBuilder();
        info.append(title);
        for (String additionalInfo : additionalInfos) {
            info
                    .append(" [")
                    .append(additionalInfo)
                    .append("]");
        }
        return info.toString();
    }

    public MenuChoice[] getChoices() {
        return choices;
    }

}
