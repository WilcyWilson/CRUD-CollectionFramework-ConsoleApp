package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.ui.ConsolePrompt;
import io.github.wilcywilson.crud.ui.UiText;
import io.github.wilcywilson.crud.ui.WizardCreator;
import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.enums.Wizard;

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
            WizardCreator.createWizard(out, Wizard.DEFINE_STORAGE_SCHEMA, additionalInfos);
            while (true) {
                ConsolePrompt.prompt(scanner, out, UiText.ENTER_COLUMN_NAME.getMessage(), s -> s);
                ConsolePrompt.prompt(scanner, out, UiText.ENTER_DATA_TYPE.getMessage(), Integer::parseInt);
                return LoopStatus.EXIT;
            }
        }
    }

}
