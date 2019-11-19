package com.tomtom.filewalker.filter;

import com.tomtom.filewalker.tools.NameExtractor;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExtension  {
    public String extensions;
    private final List<String> listOfExtensions;



    public FilterExtension(String extensions) {
        this.extensions = extensions;
        this.listOfExtensions = List.of(extensions.split(","));
    }

    public boolean test(File fileToFilter){
        return listOfExtensions
                .stream().anyMatch(extension -> NameExtractor.extractedName(fileToFilter.getName()).contains(extension));
    }

    public static List<File> filteredByExtension(List<File> listToFilter, String listOfExtensions) {
        FilterExtension filterExtension = new FilterExtension(listOfExtensions);
        List<File> filtered = listToFilter.stream()
                .filter(file -> filterExtension.test(file))
                .collect(Collectors.toList());

        return filtered;
    }
}
