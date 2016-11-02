<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<<%@ include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <br><br><br><br>
    <h1>Здесь будут мои данные и заказы. Страница будет видна залогиневшись</h1><br>

    <table class="table table-hover table-bordered">
        <tr>
          <th>#</th>
          <th>Название</th>
          <th>Описание</th>
          <th>Цена</th>
          <th>Удалить</th>
        </tr>
    <c:forEach var="list" items="${ordersList}">
    <form action="controller/?command=order&type=sub" method="post">
    <input name="id" value="${list.getId()}" type="hidden">
        <tr>
            <td><c:out value="${list.getId()}"/></td>
            <td><c:out value="${catalog.get(list.getGoods() - 1).getName()}"/></td>
            <td><c:out value="${catalog.get(list.getGoods() - 1).getDescription()}"/></td>
            <td><c:out value="${catalog.get(list.getGoods() - 1).getPrice()}"/></td>
            <td class="col-md-2"><button type="submit" class="btn btn-danger">Удалить</button></td>
        </tr>
    </form>
    </c:forEach>
    </table>
    <form action="controller/?command=order&type=buy" method="post">
    <div>
        <input name="all" value="all" type="hidden">
        <h3>Всего к оплате: <c:out value="${count}"/>$</h3>
        <button type="submit" class="btn btn-info">Подтвердить заказ</button>
    </div>
    </form>
    <br>

<%@ include file="include/footer.jsp" %>