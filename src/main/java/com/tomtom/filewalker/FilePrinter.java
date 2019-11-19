package com.tomtom.filewalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.tomtom.filewalker.tools.NameExtractor.extractedName;
import static com.tomtom.filewalker.tools.SizeConverter.convertSize;
import static com.tomtom.filewalker.tools.TypeFinder.fileType;

public class FilePrinter {

    public static List<String> printTree(List<String> receivedList) throws IOException {
        List<String> printList = receivedList;
        System.out.println("found files");
        printList.forEach(System.out::println);

        return printList;
    }

    public static List<String> convertList(List<File> fileCollection) throws IOException {
        List<String> listToPrint = new ArrayList<>();

        for (File file : fileCollection) {
                if (file.isFile() && !file.getName().startsWith(".")) {
                    listToPrint.add(fileType(file.toString()) + " " + extractedName(file.toString()) + " (" + convertSize(file.length()) + " kB)");
                } else if (file.isDirectory() && !file.getName().startsWith(".")) {
                    listToPrint.add("[dir] " + fileType(file.toString()) + extractedName(file.toString()));
                }
            }
        return listToPrint;
    }
}
