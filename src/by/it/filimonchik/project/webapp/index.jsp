<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <!-- Основное содержимое -->
    <!--  <p class="lead">Пример макета для вывода данных в виде таблицы</p>-->
      <div class="page-header">
        <h1>Все объявления</h1>
        <p class="lead">Продажа авто</p>
        <p>${user.login} ${user.email} </p>
      </div>

             <div class="row">
               <div class="col-md-3">Модель</div>
               <div class="col-md-3">Тип кузова</div>
               <div class="col-md-3">Цвет</div>
                <div class="col-md-3">Цена</div>
             </div>
          <c:forEach items="${ads}" var="ad">
             <br />
             <div class="row">
               <div class="col-md-3">${ad.FK_Model} </div>
               <div class="col-md-3">${ad.FK_Car_body}</div>
               <div class="col-md-3">${ad.FK_Color}</div>
               <div class="col-md-3">${ad.price}</div>


             </div>
          </c:forEach>

      <!--
      <h3>Заголовок. Объявления о продаже</h3>
      <p>Строка делится на 12 частей. Для каждой колонки таблицы
         можно указать класс .col-md-N, где N-число частей</p>

      <div class="row">
        <div class="col-md-3">.col-md-1</div>
        <div class="col-md-3">.col-md-1</div>
        <div class="col-md-3">.col-md-1</div>
        <div class="col-md-3">.col-md-2</div>
      </div>

      <div class="row">
        <div class="col-md-3">Модель</div>
        <div class="col-md-3">Тип кузова</div>
        <div class="col-md-3">Цвет</div>
        <div class="col-md-3">Цена</div>
      </div>

     -->

    <br><br>(${adCount})
    <t:paginator step="10" count="${adCount}" urlprefix="?startNumber="/>

<%@ include file="include/end-html.jsp" %>
