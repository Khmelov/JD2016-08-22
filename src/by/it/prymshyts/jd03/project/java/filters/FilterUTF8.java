package by.it.prymshyts.jd03.project.java.filters;

import by.it.prymshyts.jd03.project.java.controller.Action;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
           initParams = {@WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})
public class FilterUTF8 implements Filter {
    private String code;

    public void init(FilterConfig fConfig) throws ServletException {
        code = fConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        String codeResponse = response.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeResponse)) {
            response.setCharacterEncoding(code);
        }

        String codeRequest = request.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
                request.setCharacterEncoding(code);
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session    = req.getSession(true);
        session.setAttribute(Action.msgError,"Это сообщение из фильтра");
        chain.doFilter(request, response);
    }

    public void destroy() {
        code = null;
    }
}