package io.github.wilcywilson.crud.enums;

public enum UiText {
    EXITING("Exiting....."),
    INVALID_SELECTION("Invalid Selection. Please choose the correct option from the menu."),
    BACK_TO_MAIN("Back to Main Menu....."),
    ENTER_YOUR_CHOICE("Enter Your Choice : "),
    INVALID_INPUT("Invalid Input. Please try again.");

    private final String message;

    UiText(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
