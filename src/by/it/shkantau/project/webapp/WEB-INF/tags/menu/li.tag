<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ attribute name="command"  required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="glyphicon"  required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="text"  required="true" rtexprvalue="true" type="java.lang.String"%>
<%
if (command.equalsIgnoreCase(request.getParameter("command"))){
        request.setAttribute("menuClassActive","class='active'");
    }
    else
    {
        request.removeAttribute("menuClassActive");
    };
%>
<li ${menuClassActive}>
<a href="airport?command=${command}"><span class="${glyphicon}"></span>${text}</a>
</li>