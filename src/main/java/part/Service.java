package part;

import part.dto.Criteria;
import part.dto.Part;

import java.util.List;

public interface Service {
    List<Part> getAllParts();
    void sortParts(List<Part> parts, PartType partType);
    List<Part> getFilteredParts(Criteria criteria);
}
