<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Список пользователей. </p>
<table width="75%" border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td align="center"><b>Login</b></td>
        <td align="center"><b>E-mail</b></td>
        <td align="center"><b>Role</b></td>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td align="left"> ${user.login}</td>
            <td align="left">${user.email}</td>
            <td align="center">${user.fk_role}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="include/end-html.jsp" %>


