package io.github.wilcywilson.crud.ui;

public enum UiText {
    EXITING("Exiting....."),
    INVALID_SELECTION("Invalid Selection. Please choose the correct option from the menu."),
    BACK_TO_MAIN("Back to Main Menu....."),
    ENTER_YOUR_CHOICE("Enter Your Choice : "),
    INVALID_INPUT("Invalid Input. Please try again."),
    CHOOSE_STORAGE_TYPE("Choose Storage Type"),
    CHOOSE_STORAGE_ENGINE("Choose Storage Engine"),
    DEFINE_DATA_SCHEMA("Define Your Data Schema");

    private final String message;

    UiText(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
