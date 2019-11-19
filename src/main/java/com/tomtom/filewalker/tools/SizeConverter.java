package com.tomtom.filewalker.tools;

public class SizeConverter {
    public static double convertSize(double size) {
        double sizeConverted = 0;
        double kb = size / 1024;
        double mb = kb / 1024;
        if (size < 1024) {
            sizeConverted = size;
        } else if (size >= 1024 && size < (1024 * 1024)) {
            sizeConverted = kb;
        } else if (size >= (1024 * 1024)) {
            sizeConverted = mb;
        }
        return sizeConverted;
    }
}
