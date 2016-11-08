<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Редактор статей</h2>
<c:forEach items="${articles}" var="article">
    <div class="row">
        <form class="form-article-${article.ID}" action="do?command=PROFILE" method="POST">
        <br>
            <div class="row">
                <div class=col-md-1>
                    <input readonly id="article_id_${article.ID}" name="ID" type="text" value="${article.ID}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="Title" type="text" value="${article.title}" class="form-control input-md">
                </div>
            </div>
            <br>
            <textarea name="Info" class="form-control" rows="10" id="textinput">${article.info}</textarea>
            <br>
            <div class="row">
                <div class=col-md-1>
                    <button id="singlebutton" name="singlebutton" class="btn btn-success">
                        Обновить
                    </button>
                </div>

                <div class=col-md-1>
                    <button id="singlebutton" name="singlebutton"
                    class="btn btn-danger"
                    onclick="document.getElementById('article_id_${article.ID}').value=-document.getElementById('article_id_${article.ID}').value;">
                        Удалить
                    </button>
                </div>
            </div>
        </form>
    </div>
</c:forEach>

<%@ include file="include/end-html.jsp" %>