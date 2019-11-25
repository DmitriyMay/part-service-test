package part;

import part.dto.Criteria;
import part.dao.DAO;
import part.dto.Part;
import util.SortParts;
import util.factory.SortField;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class PartServiceImpl implements Service {

    @Inject
    private DAO dao;

    @Override
    public List < Part > getAllParts() {
        return dao.getAllParts();
    }

    public void sortParts(SortField sortField, List < Part > parts) {
        SortParts.sortParts(sortField, parts);
    }

    @Override
    public List < Part > getFilteredParts(Criteria criteria) {
        return dao.getFilteredParts(criteria);
    }
}
