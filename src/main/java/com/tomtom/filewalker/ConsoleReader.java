package com.tomtom.filewalker;

import com.tomtom.filewalker.filter.FilterExtension;
import com.tomtom.filewalker.filter.FilterName;
import com.tomtom.filewalker.filter.FilterSizeRange;

import java.io.File;
import java.util.Scanner;

public class ConsoleReader {
    private Scanner input = new Scanner(System.in);

    public String getString() {
        return input.nextLine();
    }

    public void close(){
        input.close();
    }

    public int getInt(){
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
    public FileTreeReader readToTree() {
        System.out.println("Type the directory:");
        String directory = input.nextLine();

        return new FileTreeReader(directory);
    }

    public FilterName readFilterByName() {
        System.out.println("Type the name you want to search by:");
        String patternValue = input.nextLine();

        return new FilterName(patternValue);

    }

    public FilterExtension readFilterByExtension() {
        System.out.println("Type the extensions (split them with a comma):");
        String extensions = input.nextLine();

        return new FilterExtension(extensions);
    }

    public FilterSizeRange readFilterBySize() {
        System.out.println("Type the min size:");
        double minSize = input.nextDouble();
        input.nextLine();
        System.out.println("Type the max size:");
        double maxSize = input.nextDouble();
        input.nextLine();

        return new FilterSizeRange(minSize, maxSize);
    }
}