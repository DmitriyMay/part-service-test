package util.factory;

import part.PartType;

public class SortFactory {

    public static SortField getSortField(PartType partType) throws IllegalArgumentException {
        if (partType == PartType.PN)
            return new SortFieldPartNumber();
        else if (partType == PartType.PART_NAME)
            return new SortFieldPartName();
        else if (partType == PartType.VENDOR)
            return new SortFieldPartVendor();
        else if (partType == PartType.QTY)
            return new SortFieldPartQty();
        else if (partType == PartType.SHIPPED)
            return new SortFieldPartShipped();
        else if (partType == PartType.RECEIVE)
            return new SortFieldPartReceive();
        else throw new IllegalArgumentException();
    }
}
