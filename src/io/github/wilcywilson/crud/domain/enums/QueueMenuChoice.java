package io.github.wilcywilson.crud.domain.enums;

import io.github.wilcywilson.crud.shared.menu.MenuChoice;

public enum QueueMenuChoice implements MenuChoice {
    PRIORITY_QUEUE(1, "PriorityQueue"),
    ARRAY_DEQUE(2, "ArrayDeque");

    private final int code;
    private final String displayName;

    QueueMenuChoice(int code, String displayName){
        this.code = code;
        this.displayName = displayName;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
