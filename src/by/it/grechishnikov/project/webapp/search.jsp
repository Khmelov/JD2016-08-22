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
    <h1>Результаты поиска:<br><small>Выберите понравившиеся вам обои и добавьте их в корзину.</small></h1>
    </div>

    <table class="table table-hover table-bordered">
      <tr>
        <th class="align">№</th>
        <th class="align">Название</th>
        <th class="align">Описание</th>
        <th class="align">Цена($)</th>
        <th class="align">Заказать</th>
      </tr>
     <c:forEach var="goods" items="${result}">
      <form action="controller/?command=order&type=add" method="post">
      <input name="id" value="${goods.getId()}" type="hidden">
      <tr>
        <td><c:out value="${goods.getId()}"/></td>
        <td><c:out value="${goods.getName()}"/></td>
        <td><c:out value="${goods.getDescription()}"/></td>
        <td><c:out value="${goods.getPrice()}"/></td>
        <td class="col-md-2"><button type="submit" class="btn btn-success">В корзину</button></td>
      </tr>
      </c:forEach>
    </table>
