package util;

import part.PartType;
import part.dto.Part;

import java.util.Comparator;

public class PartComparator implements Comparator< Part > {

    private PartType partType;
    private SortType sortType;

    PartComparator(SortType sortType, PartType partType) {
        this.partType = partType;
        this.sortType = sortType;
    }

    @Override
    public int compare(Part o1, Part o2) {
        if (isSortTypeAsc())
            return getSortAsc(o1, o2);
         else
             return getSortDesc(o1, o2);
    }

    private boolean isSortTypeAsc() {
        return sortType == SortType.ASC;
    }

    private int getSortAsc(Part o1, Part o2) {
        return getSort(o1, o2);
    }

    private int getSortDesc(Part o1, Part o2) {
        return getSort(o2, o1);
    }

    private int getSort(Part o1, Part o2) {
        if (isPartType(PartType.PN)) {
            return o1.getPartNumber().compareTo(o2.getPartNumber());
        } else if (isPartType(PartType.PART_NAME)) {
            return o1.getPartName().compareTo(o2.getPartName());
        } else if (isPartType(PartType.VENDOR)) {
            return o1.getVendor().compareTo(o2.getVendor());
        } else if (isPartType(PartType.QTY)) {
            return o1.getQty().compareTo(o2.getQty());
        } else if (isPartType(PartType.SHIPPED)) {
            return o1.getShipped().compareTo(o2.getShipped());
        } else if (isPartType(PartType.RECEIVE)) {
            return o1.getReceive().compareTo(o2.getReceive());
        }
        return 0;
    }

    private boolean isPartType(PartType partType) {
        return this.partType == partType;
    }

}
