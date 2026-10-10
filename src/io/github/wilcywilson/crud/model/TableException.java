package io.github.wilcywilson.crud.model;

import java.io.Serial;

// Why Runtime unchecked Exception and not checked Exception
// Because unchecked exception plays well with Functional Interfaces
// Records can’t throw checked exceptions.
public class TableException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    // version stamp of a class that ensures same class version during serialization and deserialization

    public TableException(String message){
        super(message);
    }
}
