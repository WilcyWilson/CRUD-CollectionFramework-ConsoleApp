package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.shared.interfaces.MenuChoice;

import java.io.PrintStream;

public class MenuCreator {
    public static void createMenu(PrintStream out, Menu menu, String... additionalInfos) {
        StringBuilder options = new StringBuilder();
        for (MenuChoice menuChoice : menu.getChoices()) {
            if (!(menuChoice.getValue() < 0)) {
                options
                        .append(menuChoice.getValue())
                        .append(".")
                        .append(menuChoice.getName())
                        .append("\n");
            }
        }
        if (additionalInfos.length < 1) {
            out.printf("""
                    ------ %s ------
                    %s""", menu.getTitle(), options);
        } else {
            out.printf("""
                    ------ %s ------
                    %s""", menu.getTitle(additionalInfos), options);
        }

    }
}
