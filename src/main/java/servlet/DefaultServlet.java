package servlet;

import part.Service;
import part.dto.Part;

import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class DefaultServlet extends HttpServlet {

    @Inject
    private Service service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List< Part > parts = service.getAllParts();

        req.setAttribute("part", parts);

        req.getRequestDispatcher("start.jsp").forward(req, resp);
    }
}
