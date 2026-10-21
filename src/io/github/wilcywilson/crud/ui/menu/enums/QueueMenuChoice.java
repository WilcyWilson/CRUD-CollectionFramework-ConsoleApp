package io.github.wilcywilson.crud.ui.menu.enums;

import io.github.wilcywilson.crud.ui.menu.MenuChoice;

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
