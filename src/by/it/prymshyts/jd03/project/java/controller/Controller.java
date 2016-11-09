package by.it.prymshyts.jd03.project.java.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/do")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(Action.msgMessage, FormHelper.strDebugForm(request));

        ActionFactory client  = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        String viewPage = command.execute(request);

        response.setHeader("Cache-Control", "no-store");

        if (viewPage != null) {
            getServletContext().getRequestDispatcher(viewPage).forward(request, response);
        } else {
            viewPage = Action.ERROR.inPage;
            response.sendRedirect(request.getContextPath() + viewPage);
        }
    }
}