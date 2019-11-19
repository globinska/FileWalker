package com.tomtom.filewalker.tools;

import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;

public class TypeFinder {
    public static String fileType(String fileName) throws IOException {
        File file = new File(String.valueOf(fileName));
        String typeFound = FilenameUtils.getExtension(file.getName());
        switch (typeFound){
            case "jpg":
            case "png":
                typeFound = "(image)";
                break;
            case "txt":
            case "doc":
                typeFound = "(doc)";
                break;
            case "csv":
                typeFound = "(data)";
                break;
            case "java":
                typeFound = "(code)";
                break;
            default:
                typeFound = FilenameUtils.getExtension(fileName);
                break;
        }
        return typeFound;
    }
}
