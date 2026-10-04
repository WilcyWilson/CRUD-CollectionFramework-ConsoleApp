package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.interfaces.MenuOperations;

import java.awt.*;

public class MenuCreator {
    public static String createMenu(MenuOperations menuOperations) {
        return """
                %s
                %s
                """.formatted(menuOperations.retrieveTitle(), menuOperations.retrieveOptions());
    }
}
