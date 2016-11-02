package by.it.grechishnikov.project.webapp;

import by.it.grechishnikov.project.webapp.java.command.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletController extends HttpServlet {
    //TODO разобраться с сессией и куками, сделать динамичную верхнюю полосу
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    private void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsp = Switcher.request(req, resp);
        //проверяем на редирект
        if(jsp.equals(Commands.GO_TO_LOGIN.message)) {
            resp.sendRedirect(req.getContextPath() + Commands.LOGIN.message);
        } else if (jsp.equals(Commands.GO_TO_SIGN_UP.message)) {
            resp.sendRedirect(req.getContextPath() + Commands.SIGN_UP.message);
        } else {
            resp.setHeader("Cache-Control", "no-store");
            if (!jsp.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + jsp);
            } else {
                getServletContext().getRequestDispatcher(Switcher.getJsp(Commands.ERROR, req, resp)).forward(req, resp);
            }
        }
    }
}