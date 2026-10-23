package io.github.wilcywilson.crud.ui;

import io.github.wilcywilson.crud.ui.menu.enums.Wizard;

import java.io.PrintStream;

public enum WizardCreator {
    ;

    public static void createWizard(PrintStream out, Wizard wizard, String... additionalInfos) {
        out.printf("""
                ------ %s ------
                """, wizard.getTitle(additionalInfos));
    }

}
