package io.github.wilcywilson.crud.shared.interfaces;

import io.github.wilcywilson.crud.domain.enums.LoopStatus;

import java.io.PrintStream;
import java.util.Scanner;

public interface Operations {
    LoopStatus run(Scanner scanner, PrintStream out);

    String getAdditionalInfo();

    void setAdditionalInfo(String additionalInfo);
}
