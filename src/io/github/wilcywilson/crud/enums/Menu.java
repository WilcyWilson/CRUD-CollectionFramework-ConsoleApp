package io.github.wilcywilson.crud.enums;

import io.github.wilcywilson.crud.interfaces.MenuChoice;

public enum Menu {
    MAIN("Main Menu", MainMenuChoice.values()),
    CRUD("CRUD Menu", CrudChoice.values());

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
            info.append(" [").append(additionalInfo).append("]");
        }
        return info.toString();
    }

    public MenuChoice[] getChoices() {
        return choices;
    }

}
