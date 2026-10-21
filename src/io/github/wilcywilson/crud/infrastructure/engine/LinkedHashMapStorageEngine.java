package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.MapOperations;

public class LinkedHashMapStorageEngine implements MapOperations {

    private final String additionalInfo;

    public LinkedHashMapStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run() {
        return null;
    }
}
