package servlet;

import part.PartType;
import part.Service;
import part.dto.Part;
import util.ConversionJson;

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
        ConversionJson.setRootNodeFromHttpRequest(req);

        PartType partType = ConversionJson.getPartTypeFromJson();
        List<Part> parts = ConversionJson.getPartsListFromJson();

        service.sortParts(parts, partType);

        resp.setContentType("text/plain");
        String partsJson = ConversionJson.getPartsJsonFromObject(parts);
        resp.getWriter().write(partsJson);
    }
}
