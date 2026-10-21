package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.ui.menu.enums.LoopStatus;
import io.github.wilcywilson.crud.ui.menu.MapOperations;

public class TreeMapStorageEngine implements MapOperations {

    private final String additionalInfo;

    public TreeMapStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run() {
        return null;
    }
}
