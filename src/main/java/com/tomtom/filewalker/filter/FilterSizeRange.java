package com.tomtom.filewalker.filter;

import com.tomtom.filewalker.tools.NameExtractor;
import com.tomtom.filewalker.tools.SizeConverter;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FilterSizeRange  {
    public double minSize;
    public double maxSize;

    public FilterSizeRange(double minSize, double maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public boolean test(File fileToFilter) {
        if (NameExtractor.extractedName(fileToFilter.getName()).startsWith("[dir]")) {
            return false;
        }
        double fileSize = SizeConverter.convertSize(fileToFilter.length());

        return fileSize >= minSize && fileSize <= maxSize;
    }

    public static List<File> filteredBySize(List<File> listToFilter, double minSize, double maxSize){
        FilterSizeRange filterSizeRange = new FilterSizeRange(minSize, maxSize);
        List<File> filtered = listToFilter.stream()
                .filter(file -> filterSizeRange.test(file))
                .collect(Collectors.toList());

        return filtered;
    }

}

