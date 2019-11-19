package com.tomtom.filewalker.sorter;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortName {
    public static List<File> sortList(List<File> toSort) {
                List<File> sortedListName = toSort.stream()
                        .sorted(Comparator.comparing(File::getName))
                        .collect(Collectors.toList());
                return sortedListName;
    }
}
