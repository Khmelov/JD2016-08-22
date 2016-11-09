package by.it.shkantau.jd03.jd03_04.classWork.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet  extends HttpServlet{
    private String message;


    @Override
    public void init() throws ServletException {
            // Do required initialization
            message = "Hello World";
    }

    @java.lang.Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer =  resp.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Sample Application Servlet Page</title>");
        writer.println("</head>");
        writer.println("<body bgcolor=white>");
        writer.println("<table border=\"0\" cellpadding=\"10\">");
        writer.println("<tr><td><h1>Sample Application by du4 Servlet</h1></td></tr>");
        writer.println("<tr>");
        writer.println("<td>");
        writer.println("<img src=\"include/java.png\">");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();
    }

    @Override
    public void destroy() {
    }
}
