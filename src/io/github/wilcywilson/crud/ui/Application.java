package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.MainMenuChoice;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.shared.menu.Operations;
import io.github.wilcywilson.crud.ui.menu.*;

import java.io.PrintStream;
import java.util.Scanner;

public class Application extends AbstractMenu<MainMenuChoice> {

    public Application(Scanner scanner, PrintStream out) {
        super(scanner, out, Menu.MAIN, MainMenuChoice.class, UiText.EXITING.getMessage(), LoopStatus.EXIT);
    }

    @Override
    protected Operations createOperation(MainMenuChoice mainMenuChoice) {
        return switch (mainMenuChoice) {
            case LIST -> new ListMainMenu(scanner, out, mainMenuChoice.getDisplayName());
            case MAP -> new MapMainMenu(scanner, out, mainMenuChoice.getDisplayName());
            case QUEUE -> new QueueMainMenu(scanner, out, mainMenuChoice.getDisplayName());
            case SET -> new SetMainMenu(scanner, out, mainMenuChoice.getDisplayName());
        };
    }
}
