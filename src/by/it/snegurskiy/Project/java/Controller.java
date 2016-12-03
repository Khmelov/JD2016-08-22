package by.it.snegurskiy.Project.java;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(urlPatterns = "/do",name="Controller")
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action nexAction= null;
        try {
            nexAction = action.execute(req);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        Action actions =Actions.defineFrom(req);
        try {
            actions.execute(req);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RequestDispatcher r=
                getServletContext().
                        getRequestDispatcher(actions.getJsp());
        r.forward(req,resp);
    }
}
