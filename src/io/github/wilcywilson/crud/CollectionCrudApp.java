package io.github.wilcywilson.crud;

import io.github.wilcywilson.crud.entrypoint.Application;

import java.util.Scanner;

public class CollectionCrudApp {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var out = System.out;
        new Application(scanner, out).run();
    }
}
