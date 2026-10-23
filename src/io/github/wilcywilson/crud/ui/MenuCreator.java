package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.ui.menu.enums.Menu;
import io.github.wilcywilson.crud.ui.menu.enums.StandardMenuChoice;
import io.github.wilcywilson.crud.ui.menu.MenuChoice;

import java.io.PrintStream;

public enum MenuCreator {
    ;

    public static void createMenu(PrintStream out, Menu menu, String... additionalInfos) {
        StringBuilder options = new StringBuilder();
        for (MenuChoice menuChoice : menu.getChoices()) {
            options
                    .append(menuChoice.getCode())
                    .append(". ")
                    .append(menuChoice.getDisplayName())
                    .append("\n");
        }
        options
                .append(StandardMenuChoice.EXIT.getCode())
                .append(". ")
                .append(StandardMenuChoice.EXIT.getDisplayName())
                .append("\n");

        out.printf("""
                ------ %s ------
                %s""", menu.getTitle(additionalInfos), options);

    }
}
