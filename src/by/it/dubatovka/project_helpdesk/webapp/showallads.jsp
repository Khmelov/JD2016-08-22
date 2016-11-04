<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Список пользователей. </p>
<table width="100%" border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td align="center"><b>ID</b></td>
        <td align="center"> <b>Subject</b></td>
        <td align="center"><b>Description</b></td>
        <td align="center"><b>ЗИА</b></td>
        <td align="center"><b>Статус</b></td>
        <td align="center"><b>Пользователь</b></td>
        <td align="center"><b>Приоритет</b></td>

    </tr>
    <c:forEach items="${adsList}" var="ad">
        <tr>
            <td align="center"> ${ad.id}</td>
            <td align="left">${ad.subject}</td>
            <td align="left">${ad.description}</td>
            <td align="center">${ad.fk_zia}</td>
            <td align="center">${ad.fk_status}</td>
            <td align="center">${ad.fk_user}</td>
            <td align="center">${ad.fk_priority}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="include/end-html.jsp" %>


