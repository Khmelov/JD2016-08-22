<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="row">
        <h2>Список статей:</h2>
    </div>
        <c:forEach items="${articles}" var="article">
            <div class="row">
                <div class="container">
                    <h3>${article.title}</h3>
                    <blockquote>
                        <p>${article.info}</p>
                        <footer>
                            <c:forEach items="${users}" var="user">
                                ${user.ID == article.FK_User ? user.login : ""}
                            </c:forEach>
                        </footer>
                    </blockquote>
            <hr>
            </div>
        </c:forEach>

<%@ include file="include/end-html.jsp" %>