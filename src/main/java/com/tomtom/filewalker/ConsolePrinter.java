package com.tomtom.filewalker;

import com.tomtom.filewalker.filter.FilterExtension;
import com.tomtom.filewalker.filter.FilterName;
import com.tomtom.filewalker.filter.FilterSizeRange;
import com.tomtom.filewalker.sorter.SortExtension;
import com.tomtom.filewalker.sorter.SortName;
import com.tomtom.filewalker.sorter.SortSize;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConsolePrinter {
    private ConsoleReader consoleReader = new ConsoleReader();

    void controlLoop() {
        DisplayOption option;
        do {
            printDisplayOptions();
            option = getDisplayOption();
            switch (option) {
                case LIST_FILES:
                    displayFileTree();
                    break;
                case FILTER_BY_NAME:
                    displayTreeFilteredByName();
                    break;
                case FILTER_BY_EXTENSION:
                    displayTreeFilteredByExtension();
                    break;
                case FILTER_BY_SIZE:
                    displayTreeFilteredBySize();
                    break;
                case SORT_FILES_BY_NAME:
                    displayTreeSortedByName();
                case SORT_FILES_BY_EXTENSION:
                    displayTreeSortedByExtension();
                    break;
                case SORT_FILES_BY_SIZE:
                    displayTreeSortedBySize();
                    break;
                case EXIT:
                    exit();

                    default:
                    System.out.println("There is no such option, try again!");
            }
        } while (option != DisplayOption.EXIT);
    }

    private DisplayOption getDisplayOption() {
        boolean optionOk = false;
        DisplayOption option = null;
        while (!optionOk) {
                option = DisplayOption.createFromInt(consoleReader.getInt());
                optionOk = true;
        }
        return option;
    }

    private void printDisplayOptions() {
        System.out.println("choose the option");
        for (DisplayOption option : DisplayOption.values()) {
            System.out.println(option.toString());
        }
    }

    private void displayFileTree() {
        try {
            FileTreeReader treeReader = consoleReader.readToTree();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(fileTreeReader)));
        } catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }
    private void displayTreeFilteredByName() {
        try {
            FileTreeReader treeReader = consoleReader.readToTree();
            FilterName filterByName = consoleReader.readFilterByName();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(FilterName.filteredByName(fileTreeReader, filterByName.patternValue))));
        } catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }
    private void displayTreeFilteredByExtension() {
        try {
            FileTreeReader treeReader = consoleReader.readToTree();
            FilterExtension filterByExtension = consoleReader.readFilterByExtension();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(FilterExtension.filteredByExtension(fileTreeReader, filterByExtension.extensions))));
        }catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }


    private void displayTreeFilteredBySize() {
        try {
            FileTreeReader treeReader = consoleReader.readToTree();
            FilterSizeRange filterBySizeRange = consoleReader.readFilterBySize();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(FilterSizeRange.filteredBySize(fileTreeReader, filterBySizeRange.minSize, filterBySizeRange.maxSize ))));
        } catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }

    private void displayTreeSortedByName(){
        try{
            FileTreeReader treeReader = consoleReader.readToTree();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(SortName.sortList(fileTreeReader))));
        }catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }
    private void displayTreeSortedByExtension(){
        try{
            FileTreeReader treeReader = consoleReader.readToTree();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(SortExtension.sortList(fileTreeReader))));
        }catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }

    private void displayTreeSortedBySize(){
        try{
            FileTreeReader treeReader = consoleReader.readToTree();
            List<File> fileTreeReader = FileTreeReader.readFileTree(treeReader.directory);
            System.out.println(FilePrinter.printTree(FilePrinter.convertList(SortSize.sortList(fileTreeReader))));
        }catch (ArrayIndexOutOfBoundsException | IOException a) {
            System.out.println("Wrong value, try once again");
        }
    }

    private void exit() {
        consoleReader.close();
        System.out.println("See ya!");
    }

    public enum DisplayOption {
        LIST_FILES(0, " - show all files and directories"),
        FILTER_BY_NAME(1, " - filter by name"),
        FILTER_BY_EXTENSION(2, " - filter by extension"),
        FILTER_BY_SIZE(3, " - filter by size "),
        SORT_FILES_BY_NAME(4, " - sort files by names"),
        SORT_FILES_BY_EXTENSION(5, " - sort files by extension"),
        SORT_FILES_BY_SIZE(6, " - sort files by size"),
        EXIT(7, " - exit");

        private int value;
        private String description;

        DisplayOption(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " " + description;
        }

        public static DisplayOption createFromInt(int option) {
            return DisplayOption.values()[option];
        }
    }
}

