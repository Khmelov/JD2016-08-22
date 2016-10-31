package by.it.grechishnikov.project.webapp.java;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
            initParams = {
                    @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")
            })
public class UTF8 implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String codeResponse = servletResponse.getCharacterEncoding();

        if(code != null && !code.equalsIgnoreCase(codeResponse)) {
            servletResponse.setCharacterEncoding(code);
        }

        String codeRequest = servletRequest.getCharacterEncoding();

        if(code != null && !code.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(code);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
