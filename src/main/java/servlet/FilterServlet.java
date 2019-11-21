package servlet;

import part.dto.Criteria;
import part.Service;
import part.dto.Part;
import util.ConversionJson;

import javax.inject.Inject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.text.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/parts")
public class FilterServlet extends HttpServlet {

    @Inject
    private Service service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> parameters = getParameters(req);
        Criteria criteria = createCriteria(parameters);


        List< Part > parts = service.getFilteredParts(criteria);

        resp.setContentType("text/plain");
        String partsJson = ConversionJson.getPartsJsonFromObject(parts);

        resp.getWriter().write(partsJson);
    }

    private Criteria createCriteria(Map <String, String> parameters) {
        Criteria criteria = new Criteria();
        criteria.setPartNumber(parameters.get("PN"));
        criteria.setPartName(parameters.get("Part Name"));
        criteria.setVendor(parameters.get("Vendor"));
        criteria.setQty(parameters.get("Qty"));

        try {
            criteria.setShippedAfter(parameters.get("Shipped after"));
            criteria.setShippedBefore(parameters.get("Shipped before"));
            criteria.setReceiveAfter(parameters.get("Receive after"));
            criteria.setReceiveBefore(parameters.get("Receive before"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return criteria;
    }

    private Map <String, String> getParameters(HttpServletRequest req) {
        Map<String, String> parameters = new HashMap <>();

        parameters.put("PN", req.getParameter("PN"));
        parameters.put("Part Name", req.getParameter("Part Name"));
        parameters.put("Vendor", req.getParameter("Vendor"));
        parameters.put("Qty", req.getParameter("Qty"));
        parameters.put("Shipped after", req.getParameter("Shipped after"));
        parameters.put("Shipped before", req.getParameter("Shipped before"));
        parameters.put("Receive after", req.getParameter("Receive after"));
        parameters.put("Receive before", req.getParameter("Receive before"));

        return parameters;
    }
}
