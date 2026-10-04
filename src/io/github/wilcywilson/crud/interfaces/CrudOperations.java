package io.github.wilcywilson.crud.interfaces;

import java.util.Scanner;

public interface CrudOperations {
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

    void crudMainLoop(Scanner scanner);
}
