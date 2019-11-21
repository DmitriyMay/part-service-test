package part.dao;

import part.dto.Criteria;
import part.dto.Part;

import java.util.List;

public interface DAO {
    List<Part> getAllParts();
    List<Part> getFilteredParts(Criteria criteria);
}
