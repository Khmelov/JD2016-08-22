package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

//@WebServlet("/airport")
public class FrontController extends HttpServlet {
    static final String CSPATH = "csPath";
    private String csPath;

    @Override
    public void init() throws ServletException {
            csPath = getServletContext().getRealPath("/WEB-INF/CSettings.json");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(CSPATH, csPath);
        writeUpdSessionStr(request);

        Action action = Actions.defineFrom(request);
        Action nextAction = action.execute(request);

        if (nextAction == null){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(action.getJsp());
            requestDispatcher.forward(request,response);
        }else {
            response.sendRedirect("airport?command="+nextAction);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(CSPATH, csPath);

        writeUpdSessionStr(request);

        Action action = Actions.defineFrom(request);
        action.execute(request);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(action.getJsp());
        requestDispatcher.forward(request,response);
    }

    private void writeUpdSessionStr(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        User userFromSession =  (User)session.getAttribute("user");
        if (userFromSession != null) {
            request.setAttribute("curUser","Session info: user.login="+userFromSession.getLogin()+", created at-" +new Timestamp(session.getLastAccessedTime()));
            request.setAttribute("user",userFromSession);
//            session.setAttribute("user",userFromSession); // update session
        }else {
            request.setAttribute("user",null);
        }
    }
}