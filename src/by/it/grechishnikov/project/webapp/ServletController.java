package by.it.grechishnikov.project.webapp;

import by.it.grechishnikov.project.webapp.command.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.*;

public class ServletController extends HttpServlet {
    public static Logger logger = Logger.getLogger(ServletController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "\n****DO_GET****");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "\n****DO_POST****");
        processRequest(req, resp);
    }
    private void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsp = Switcher.request(req, resp);
        logger.log(Level.INFO, "\n****" + jsp + "****");
        //проверяем на редирект
        if(jsp.equals(Commands.GO_TO_LOGIN.message)) {
            resp.sendRedirect(req.getContextPath() + Commands.LOGIN.message);
            return;
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