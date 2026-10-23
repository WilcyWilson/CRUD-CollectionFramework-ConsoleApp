package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.ui.UiText;
import io.github.wilcywilson.crud.ui.WizardCreator;
import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class AbstractDataSchema implements Operations {

    protected final Scanner scanner;
    protected final PrintStream out;
    private final String[] additionalInfos;

    protected AbstractDataSchema(Scanner scanner, PrintStream out, String... additionalInfos) {
        this.scanner = scanner;
        this.out = out;
        this.additionalInfos = additionalInfos;
    }

    @Override
    public LoopStatus run() {
        while (true) {
            WizardCreator.createWizard(out, UiText.DEFINE_DATA_SCHEMA.getMessage(), additionalInfos);
            return LoopStatus.EXIT;
        }
    }

}
