package by.it.grechishnikov.jd03_04.project;

import by.it.grechishnikov.jd03_04.project.command.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsp = Switcher.request(req);
        resp.setHeader("Cache-Control", "no-store");
        if(jsp.isEmpty()) {
            getServletContext().getRequestDispatcher(Switcher.getJsp(Commands.ERROR)).forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher(jsp).forward(req, resp);
        }
    }
}
