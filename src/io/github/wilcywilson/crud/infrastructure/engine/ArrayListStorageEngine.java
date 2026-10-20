package io.github.wilcywilson.crud.infrastructure.engine;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;
import io.github.wilcywilson.crud.shared.menu.ListOperations;

public class ArrayListStorageEngine implements ListOperations {
    private final String additionalInfo;

    public ArrayListStorageEngine(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public LoopStatus run() {
        return null;
    }
}
