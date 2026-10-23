package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.ui.MenuCreator;
import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.enums.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class AbstractDataSchema implements Operations {

    protected final Scanner scanner;
    protected final PrintStream out;
    private final Menu menuType;
    private final String[] additionalInfos;

    protected AbstractDataSchema(Scanner scanner, PrintStream out, Menu menuType, String... additionalInfos) {
        this.scanner = scanner;
        this.out = out;
        this.menuType = menuType;
        this.additionalInfos = additionalInfos;
    }

    @Override
    public LoopStatus run() {
        while (true) {
            MenuCreator.createMenu(out, menuType, additionalInfos);
            return LoopStatus.EXIT;
        }
    }

}
