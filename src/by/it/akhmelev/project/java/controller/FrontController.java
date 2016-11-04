package by.it.akhmelev.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/do",name="FronController")
public class FrontController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        Action nexAction=action.execute(req);
        if (nexAction==null) {
        RequestDispatcher r =
         getServletContext().
           getRequestDispatcher(action.getJsp());
        r.forward(req,resp);
        }
        else
           resp.sendRedirect("do?command="+nexAction);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        action.execute(req);
        RequestDispatcher r=
         getServletContext().
          getRequestDispatcher(action.getJsp());
        r.forward(req,resp);
    }
}
