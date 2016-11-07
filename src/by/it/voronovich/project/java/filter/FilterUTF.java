package by.it.voronovich.project.java.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})

public class FilterUTF implements Filter {
    private String coding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        coding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String codingRequest = request.getCharacterEncoding();

        // установка кодировки из параметров фильтра, если не установлена
        if (coding != null && !coding.equalsIgnoreCase(codingRequest)) {
            request.setCharacterEncoding(coding);
        }

        String codingResponse = response.getCharacterEncoding();
        if (coding != null && !coding.equalsIgnoreCase(codingResponse)) {
            response.setCharacterEncoding(coding);
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        coding = null;
    }
}