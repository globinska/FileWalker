package com.tomtom.filewalker.sorter;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortSize {
    public static List<File> sortList(List<File> toSort) {

        List<File> sortedListSize = toSort.stream()
                .sorted(Comparator.comparing(File::length))
                .collect(Collectors.toList());
        return sortedListSize;
    }
}
