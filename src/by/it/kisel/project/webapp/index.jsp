<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Все комнаты</h1>
     <!--   <p class="lead">Пример макета для вывода данных в виде таблицы</p> -->
        <p>${persons.email}</p>
      </div>

             <div class="row">
               <div class="col-md-1">№</div>
               <div class="col-md-2">Число комнат</div>
               <div class="col-md-2">Качество</div>
               <div class="col-md-2">Цена за день</div>
               <div class="col-md-2">Кондиционер</div>
               <div class="col-md-3">Описание</div>
             </div>
          <% Integer i=0; %>
          <c:forEach items="${roomss}" var="rooms">
             <br />
             <div class="row">
               <div class="col-md-1"><% out.print(++i); %></div>
               <div class="col-md-2">${rooms.roomCount} </div>
               <div class="col-md-2">${rooms.quality}</div>
               <div class="col-md-2">${rooms.priceForDay}</div>
               <div class="col-md-2">${rooms.conditioner}</div>
               <div class="col-md-3">${rooms.description}</div>

             </div>
          </c:forEach>

      <!--
      <h3>Заголовок. Объявления о продаже</h3>
      <p>Строка делится на 12 частей. Для каждой колонки таблицы
         можно указать класс .col-md-N, где N-число частей</p>

      <div class="row">
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-2">.col-md-2</div>
        <div class="col-md-3">.col-md-3</div>
        <div class="col-md-2">.col-md-2</div>
        <div class="col-md-3">.col-md-3</div>
      </div>

      <div class="row">
         <div class="col-md-1">Число комнат</div>
         <div class="col-md-2">Качество</div>
         <div class="col-md-3">Цена за день</div>
         <div class="col-md-2">Кондиционер</div>
         <div class="col-md-2">Описание</div>
        <div class="col-md-2">Автор</div>
      </div>

     -->

<br><br>(${roomsCount})
<t:paginator step="10" count="${roomsCount}" urlprefix="?startNumber="/>


<%@ include file="include/end-html.jsp" %>
