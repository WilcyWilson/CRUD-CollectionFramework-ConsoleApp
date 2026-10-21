package io.github.wilcywilson.crud.ui.menu;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.domain.enums.Menu;
import io.github.wilcywilson.crud.domain.enums.QueueMenuChoice;
import io.github.wilcywilson.crud.infrastructure.engine.HashMapStorageEngine;
import io.github.wilcywilson.crud.infrastructure.engine.LinkedHashMapStorageEngine;
import io.github.wilcywilson.crud.shared.menu.Operations;
import io.github.wilcywilson.crud.ui.UiText;

import java.io.PrintStream;
import java.util.Scanner;

public class QueueMainMenu extends AbstractMenu<QueueMenuChoice> {
    public QueueMainMenu(Scanner scanner, PrintStream out, String additionalInfo) {
        super(scanner, out, Menu.QUEUE_STORAGE_ENGINE, QueueMenuChoice.class, UiText.BACK_TO_MAIN.getMessage(), LoopStatus.CONTINUE, additionalInfo);
    }

    @Override
    protected Operations createOperation(QueueMenuChoice queueMenuChoice) {
        return switch (queueMenuChoice) {
            case PRIORITY_QUEUE -> new HashMapStorageEngine(queueMenuChoice.getDisplayName());
            case ARRAY_DEQUE -> new LinkedHashMapStorageEngine(queueMenuChoice.getDisplayName());
        };
    }
}
