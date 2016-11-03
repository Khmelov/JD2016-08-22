<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<%@ include file="include/header.jsp" %>

    <br><br><br><br>
    <div class="navbar-collapse collapse">

    <form class="navbar-form navbar-right" role="form" action="controller/?command=search" method="post">
       <div class="form-group">
        <input id="search" name="search" type="search" placeholder="Немецкие обои" class="form-control">
       </div>
       <button type="submit" class="btn btn-success">Поиск</button>
    </form>
    <h1>Каталог обоев:<br><small>Выберите понравившиеся вам обои и нажмите "Оформить заказ".</small></h1>
    </div>

    <table class="table table-hover table-bordered">
      <tr>
        <th>№</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Заказать</th>
      </tr>
     <c:forEach var="goods" items="${catalog}">
      <form action="controller/?command=order&type=add" method="post">
      <input name="id" value="${goods.getId()}" type="hidden">
      <tr>
        <td><c:out value="${goods.getId()}"/></td>
        <td><c:out value="${goods.getName()}"/></td>
        <td><c:out value="${goods.getDescription()}"/></td>
        <td><c:out value="${goods.getPrice()}"/></td>
        <td class="col-md-2"><button type="submit" class="btn btn-success">В корзину</button></td>
      </tr>
      </form>
      </c:forEach>
    </table>

<%@ include file="include/footer.jsp" %>