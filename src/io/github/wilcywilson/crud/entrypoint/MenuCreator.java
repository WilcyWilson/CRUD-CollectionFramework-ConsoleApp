package io.github.wilcywilson.crud.entrypoint;

import io.github.wilcywilson.crud.interfaces.MenuOperations;

import java.awt.*;

public class MenuCreator {
    public static void createMenu(MenuOperations menuOperations) {
        System.out.printf("""
        ------ %s ------
        %s
        """, menuOperations.retrieveTitle(""), menuOperations.retrieveOptions());
    }
}
