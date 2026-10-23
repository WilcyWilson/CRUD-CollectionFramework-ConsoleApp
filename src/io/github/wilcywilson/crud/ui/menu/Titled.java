package io.github.wilcywilson.crud.ui.menu;

public interface Titled {
    String getBaseTitle();

    default String getTitle(String... additionalInfos) {
        StringBuilder info = new StringBuilder();
        info.append(getBaseTitle());
        for (String additionalInfo : additionalInfos) {
            info
                    .append(" [")
                    .append(additionalInfo)
                    .append("]");
        }
        return info.toString();
    }
}
