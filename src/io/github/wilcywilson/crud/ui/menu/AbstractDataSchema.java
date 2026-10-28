package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.domain.model.DataType;
import io.github.wilcywilson.crud.ui.ConsolePrompt;
import io.github.wilcywilson.crud.ui.UiText;
import io.github.wilcywilson.crud.ui.WizardCreator;
import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.enums.StandardMenuChoice;
import io.github.wilcywilson.crud.ui.menu.enums.Wizard;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringJoiner;

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
        WizardCreator.createWizard(out, Wizard.DEFINE_STORAGE_SCHEMA, additionalInfos);
        while (true) {
            int count = 0;
            String columnName;
            while (true) {
                columnName = ConsolePrompt.prompt(scanner, out, UiText.ENTER_COLUMN_NAME.format(++count), s -> s);

                if (columnName.equalsIgnoreCase(String.valueOf(StandardMenuChoice.EXIT.getCode()))) {
                    return LoopStatus.CONTINUE;
                }

                while (true) {
                    int input = ConsolePrompt.prompt(scanner, out, UiText.ENTER_DATA_TYPE.format(columnName, getDataTypeChoices()), Integer::parseInt);

                    Optional<DataType> menuChoice = MenuChoiceUtil.fromCode(DataType.class, input);

                    if (menuChoice.isEmpty()) {
                        out.println(UiText.INVALID_SELECTION.getMessage());
                    } else {
                        break;
                    }
                }

            }

        }
    }

    public String getDataTypeChoices() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (DataType dataType : DataType.values()) {
            stringJoiner.add(dataType.getCode() + " = " + dataType.getDisplayName());
        }
        return stringJoiner.toString();
    }
}





