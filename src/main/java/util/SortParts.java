package util;

import part.PartType;
import part.dto.Part;

import java.util.Collections;
import java.util.List;

public class SortParts {

    private static SortType sortType = SortType.ASC;

    public static void sortParts(List < Part > parts, PartType partType) {
        sort(parts, partType);
    }

    private static void sort(List < Part > parts, PartType partType) {
        switch (partType) {
            case PN: {
                sortByFieldPartNumber(parts);
                break;
            }
            case PART_NAME: {
                sortByFieldPartName(parts);
                break;
            }
            case VENDOR: {
                sortByFieldPartVendor(parts);
                break;
            }
            case QTY: {
                sortByFieldPartQty(parts);
                break;
            }
            case SHIPPED: {
                sortByFieldPartShipped(parts);
                break;
            }
            case RECEIVE: {
                sortByFieldPartReceive(parts);
            }
        }
    }

    private static void setSortType(SortType sortType) {
        SortParts.sortType = sortType;
    }

    private static void sortByFieldPartNumber(List < Part > parts) {
        if (isSortTypeAsc() ) {
            Collections.sort(parts, new PartComparator(SortType.ASC, PartType.PN));

            setSortType(SortType.DESC);
        }
        else {
            Collections.sort(parts, new PartComparator(SortType.DESC, PartType.PN));

            setSortType(SortType.ASC);
        }
    }

    private static boolean isSortTypeAsc() {
        return sortType == SortType.ASC;
    }

    private static void sortByFieldPartName(List < Part > parts) {
        if (isSortTypeAsc() ) {
            Collections.sort(parts, new PartComparator(SortType.ASC, PartType.PART_NAME));

            setSortType(SortType.DESC);
        }
        else {
            Collections.sort(parts, new PartComparator(SortType.DESC, PartType.PART_NAME));

            setSortType(SortType.ASC);
        }
    }

    private static void sortByFieldPartVendor(List < Part > parts) {
        if (isSortTypeAsc() ) {
            Collections.sort(parts, new PartComparator(SortType.ASC, PartType.VENDOR));

            setSortType(SortType.DESC);
        }
        else {
            Collections.sort(parts, new PartComparator(SortType.DESC, PartType.VENDOR));

            setSortType(SortType.ASC);
        }
    }

    private static void sortByFieldPartQty(List < Part > parts) {
        if (isSortTypeAsc() ) {
            Collections.sort(parts, new PartComparator(SortType.ASC, PartType.QTY));

            setSortType(SortType.DESC);
        }
        else {
            Collections.sort(parts, new PartComparator(SortType.DESC, PartType.QTY));

            setSortType(SortType.ASC);
        }
    }

    private static void sortByFieldPartShipped(List < Part > parts) {
        if (isSortTypeAsc() ) {
            Collections.sort(parts, new PartComparator(SortType.ASC, PartType.SHIPPED));

            setSortType(SortType.DESC);
        }
        else {
            Collections.sort(parts, new PartComparator(SortType.DESC, PartType.SHIPPED));

            setSortType(SortType.ASC);
        }
    }

    private static void sortByFieldPartReceive(List < Part > parts) {
        if (isSortTypeAsc() ) {
            Collections.sort(parts, new PartComparator(SortType.ASC, PartType.RECEIVE));

            setSortType(SortType.DESC);
        }
        else {
            Collections.sort(parts, new PartComparator(SortType.DESC, PartType.RECEIVE));

            setSortType(SortType.ASC);
        }
    }
}
