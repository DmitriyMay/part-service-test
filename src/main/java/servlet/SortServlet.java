package servlet;

import part.PartType;
import part.Service;
import part.dto.Part;
import util.Converter;
import util.factory.SortFactory;
import util.factory.SortField;

import javax.inject.Inject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

@WebServlet("/parts/sort")
public class SortServlet extends HttpServlet {

    @Inject
    private Service service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Converter.setRootNodeFromHttpRequest(req);

        PartType partType = Converter.getPartTypeFromJson();
        List<Part> parts = Converter.getPartsListFromJson();

        SortField sortField = SortFactory.getSortField(partType);

        service.sortParts(sortField, parts);

        resp.setContentType("text/plain");
        String partsJson = Converter.getPartsJsonFromObject(parts);
        resp.getWriter().write(partsJson);
    }
}
