package com.tomtom.filewalker.tools;

import java.io.File;

public class NameExtractor {
    public static String extractedName(String fileName) {
        File file = new File(String.valueOf(fileName));
        String name = file.getName();

        return name;
    }
}
