
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



<table width="100%" border="1" cellpadding="1" cellspacing="1">
    <tr>
        <th scope="col" bgcolor="#a9a9a9" align="center">LOGIN</th>
        <th scope="col" bgcolor="#a9a9a9" align="center">EMAIL</th>
        <th scope="col" bgcolor="#a9a9a9" align="center">ROLE</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td align="center"> ${user.login}</td>
            <td align="center">${user.email}</td>
            <%--<td align="center">${user.role}</td>--%>
            <c:choose>
                <c:when test="${user.role==1}">
                    <td align="center">Administrator</td>
                </c:when>
                <c:when test="${user.role==2}">
                    <td align="center">Dispatcher</td>
                </c:when>
                <c:when test="${user.role==3}">
                    <td align="center">User</td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>

<%@ include file="include/end-html.jsp" %>
