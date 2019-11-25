package util.factory;

import part.PartType;
import part.dto.Part;
import util.PartComparator;
import util.SortType;

import java.util.Collections;
import java.util.List;

public class SortFieldPartShipped extends SortField {

    @Override
    public void sortAsc(List < Part > parts) {
        Collections.sort(parts, new PartComparator(SortType.ASC, PartType.SHIPPED));
    }

    @Override
    public void sortDesc(List < Part > parts) {
        Collections.sort(parts, new PartComparator(SortType.DESC, PartType.SHIPPED));
    }
}
