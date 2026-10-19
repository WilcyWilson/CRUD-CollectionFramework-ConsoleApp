package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.shared.interfaces.MenuChoice;

import java.io.PrintStream;

public class MenuCreator {
    public static void createMenu(PrintStream out, Menu menu, String... additionalInfos) {
        StringBuilder options = new StringBuilder();
        for (MenuChoice menuChoice : menu.getChoices()) {
            if (!(menuChoice.getCode() < 0)) {
                options
                        .append(menuChoice.getCode())
                        .append(".")
                        .append(menuChoice.getDisplayName())
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
