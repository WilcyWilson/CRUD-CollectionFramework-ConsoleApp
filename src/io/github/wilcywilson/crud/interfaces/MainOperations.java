package io.github.wilcywilson.crud.interfaces;

import java.io.PrintStream;
import java.util.Scanner;

public interface MainOperations {
    default String crudMenu() {
        return """
                1.INSERT
                2.DISPLAY
                3.SEARCH
                4.DELETE
                5.UPDATE
                0.EXIT
                Enter Your Choice :
                
                """;
    }

    void storageEngineLoop(Scanner scanner, PrintStream out);
}
