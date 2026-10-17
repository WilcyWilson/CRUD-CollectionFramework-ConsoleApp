package io.github.wilcywilson.crud.ui;

public enum UiText {
    EXITING("Exiting....."),
    INVALID_SELECTION("Invalid Selection. Please choose the correct option from the menu."),
    BACK_TO_MAIN("Back to Main Menu....."),
    ENTER_YOUR_CHOICE("Enter Your Choice : "),
    INVALID_INPUT("Invalid Input. Please try again."),
    CHOOSE_COLLECTION_FRAMEWORK("Choose the Collection Framework"),
    CHOOSE_STORAGE_ENGINE("Choose the Storage Engine");

    private final String message;

    UiText(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
