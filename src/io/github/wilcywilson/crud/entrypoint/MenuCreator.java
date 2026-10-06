package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.enums.Menu;
import io.github.wilcywilson.crud.interfaces.MenuChoice;

public class MenuCreator {
    public static void createMenu(Menu menu, String... additionalInfos) {
        StringBuilder options = new StringBuilder();
        for (MenuChoice menuChoice : menu.getChoices()) {
            if (!(menuChoice.getValue() < 0)) {
                options
                        .append(menuChoice.getValue())
                        .append(".")
                        .append(menuChoice.name())
                        .append("\n");
            }
        }
        if (additionalInfos.length < 1) {
            System.out.printf("""
                    ------ %s ------
                    %s""", menu.getTitle(), options);
        } else {
            System.out.printf("""
                    ------ %s ------
                    %s""", menu.getTitle(additionalInfos), options);
        }

    }
}
