<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Диагнозы</h1>
     <!--   <p class="lead">Пример макета для вывода данных в виде таблицы</p> -->
        <p>${patients.second_name} ${patients.first_name}</p>
      </div>

             <div class="row">
               <div class="col-md-1">№</div>
               <div class="col-md-2">Диагноз</div>
               <div class="col-md-2">Прописанные препараты</div>
               <div class="col-md-2">Необходимость оперирования</div>
               <div class="col-md-2">Назначенные процедуры</div>
               <div class="col-md-1">ID пациента</div>
               <div class="col-md-1">ID доктора</div>
             </div>
          <% Integer i=0; %>
          <c:forEach items="${diagnostics}" var="diagnostic">
             <br />
             <div class="row">
               <div class="col-md-1"><% out.print(++i); %></div>
               <div class="col-md-2">${diagnostic.illness} </div>
               <div class="col-md-2">${diagnostic.drugs}</div>
               <div class="col-md-2">${diagnostic.operations}</div>
               <div class="col-md-2">${diagnostic.procedures}</div>
               <div class="col-md-1">${diagnostic.FK_patients}</div>
               <div class="col-md-1">${diagnostic.FK_doctors}</div>

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




<%@ include file="include/end-html.jsp" %>
