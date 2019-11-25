package part;

import part.dto.Criteria;
import part.dto.Part;
import util.factory.SortField;

import java.util.List;

public interface Service {
    List<Part> getAllParts();
    void sortParts(SortField sortField, List<Part> parts);
    List<Part> getFilteredParts(Criteria criteria);
}
