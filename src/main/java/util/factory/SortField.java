package util.factory;

import part.dto.Part;

import java.util.List;

public abstract class SortField {
    public abstract void sortAsc(List < Part > parts);
    public abstract void sortDesc(List < Part > parts);
}
