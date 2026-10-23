package io.github.wilcywilson.crud.ui;

import java.io.PrintStream;

public enum WizardCreator {
    ;

    public static void createWizard(PrintStream out, String title, String... additionalInfos) {
        out.printf("""
                ------ %s ------
                """, getTitle(title, additionalInfos));
    }

    private static String getTitle(String title, String... additionalInfos) {
        StringBuilder info = new StringBuilder();
        info.append(title);
        for (String additionalInfo : additionalInfos) {
            info
                    .append(" [")
                    .append(additionalInfo)
                    .append("]");
        }
        return info.toString();
    }
}
