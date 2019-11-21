package part.dao;

import part.dto.Criteria;
import part.dto.Part;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class PartDaoImpl implements DAO {

    @Inject
    private Connection connection;
    private PreparedStatement statement;

    @Override
    public List < Part > getAllParts() {
        String compiledQuery = "select * from parts";

        ResultSet resultSet = executeQuery(compiledQuery);

        return getParts(resultSet);
    }

    private ResultSet executeQuery(String compiledQuery) {
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(compiledQuery);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }
        return resultSet;
    }

    private List < Part > getParts(ResultSet resultSet) {
        List < Part > parts = new ArrayList <>();

        try {
            while (resultSet.next()) {
                Part part = new Part();
                part.setPartNumber(resultSet.getString(2));
                part.setPartName(resultSet.getString(3));
                part.setVendor(resultSet.getString(4));
                part.setQty(resultSet.getInt(5));
                part.setShipped(resultSet.getDate(6));
                part.setReceive(resultSet.getDate(7));

                parts.add(part);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }
        closeStatement();
        return parts;
    }

    private void closeStatement() {
        try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }
    }

    @Override
    public List < Part > getFilteredParts(Criteria criteria) {
        String compiledQuery = "select *\n" +
                                "from parts p\n" +
                                "where lower(p.part_number) like '%' || ? || '%'\n" +
                                "and lower(p.part_name) like '%' || ? || '%'\n" +
                                "and lower(p.vendor) like '%' || ? || '%'\n" +
                                "and p.shipped between ? and ? " +
                                "and p.receive between ? and ? " +
                                "and p.qty >= ?";

        ResultSet resultSet = executeQuery(compiledQuery, criteria);

        return getParts(resultSet);
    }

    private ResultSet executeQuery(String compiledQuery, Criteria criteria) {
        ResultSet resultSet;

        try {
            statement = connection.prepareStatement(compiledQuery);
            statement.setString(1, criteria.getPartNumber().toLowerCase());
            statement.setString(2, criteria.getPartName().toLowerCase());
            statement.setString(3, criteria.getVendor().toLowerCase());
            statement.setDate(4, criteria.getShippedAfter());
            statement.setDate(5, criteria.getShippedBefore());
            statement.setDate(6, criteria.getReceiveAfter());
            statement.setDate(7, criteria.getReceiveBefore());
            statement.setInt(8, criteria.getQty());

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }
        return resultSet;
    }
}
