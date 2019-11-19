package com.tomtom.filewalker;

import java.io.IOException;

public class FileWalker {
    public static void main(String[] args) throws IOException {

        System.out.println("FILE WALKER");
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.controlLoop();
    }
}