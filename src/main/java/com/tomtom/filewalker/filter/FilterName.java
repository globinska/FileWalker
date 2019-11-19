package com.tomtom.filewalker.filter;

import com.tomtom.filewalker.tools.NameExtractor;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterName implements Predicate<File> {
    public String patternValue;

    public FilterName(String patternValue) {
        this.patternValue = patternValue;
    }

    @Override
    public boolean test(File fileToFilter) {
        return NameExtractor.extractedName(fileToFilter.getName()).contains(patternValue);
    }

    public static List<File> filteredByName(List<File> listToFilter, String patternValue){
        FilterName filterName = new FilterName(patternValue);
        List<File> filtered = listToFilter.stream()
                .filter(file -> filterName.test(file))
                .collect(Collectors.toList());

        return filtered;
    }
}