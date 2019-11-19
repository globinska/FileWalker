package com.tomtom.filewalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTreeReader {
    String directory;

    public FileTreeReader(String directory) {
        this.directory = directory;
    }

    public static List<File> readFileTree(String directory) throws IOException {

        File pathDir = new File(directory);
        List<File> fileTree = new ArrayList<>();
        File[] files = pathDir.listFiles();

        for (File file : files) {
                if (file.isFile()) {
                    fileTree.add(file);
                } else if (file.isDirectory()) {
                    fileTree.add(file);
                    fileTree.addAll(readFileTree(file.getAbsolutePath()));
                }
            }

        return fileTree;
    }
}