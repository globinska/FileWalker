package com.tomtom.filewalker.sorter;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExtension {
    public static List<File> sortList(List<File> toSort) {
        List<File> sortedListExtension = toSort.stream()
                .sorted(Comparator.comparing(File::getName))
                .collect(Collectors.toList());
        return sortedListExtension;
    }
}
