package util;

import part.dto.Part;
import util.factory.SortField;

import java.util.List;

public class SortParts {

    private static SortType sortType = SortType.ASC;

    public static void sortParts(SortField sortField, List < Part > parts) {
        sort(sortField, parts);
    }

    private static void sort(SortField sortField, List < Part > parts) {
        if (isSortTypeAsc()) {
            sortField.sortAsc(parts);

            setSortType(SortType.DESC);
        } else {
            sortField.sortDesc(parts);

            setSortType(SortType.ASC);
        }
    }

    private static boolean isSortTypeAsc() {
        return sortType == SortType.ASC;
    }


    private static void setSortType(SortType sortType) {
        SortParts.sortType = sortType;
    }
}