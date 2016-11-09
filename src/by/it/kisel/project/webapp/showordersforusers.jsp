<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

     <!-- Основное содержимое -->
           <div class="page-header">
             <h1>Заказы</h1>

           </div>

                  <div class="row">
                    <div class="col-md-1">№</div>
                    <div class="col-md-1">Дата заселения</div>
                    <div class="col-md-2">Дата выселения</div>
                    <div class="col-md-3">Цена</div>
                    <div class="col-md-2">ID комнаты</div>
                    <div class="col-md-3">ID заказчика</div>
                  </div>
               <% Integer i=0; %>
               <c:forEach items="${ordersforusers}" var="orders">
                  <br />
                  <div class="row">
                    <div class="col-md-1"><% out.print(++i); %></div>
                    <div class="col-md-1">${orders.arrivalDate} </div>
                    <div class="col-md-2">${orders.departureDate}</div>
                    <div class="col-md-3">${orders.totalPrice}</div>
                    <div class="col-md-2">${orders.FK_rooms}</div>
                    <div class="col-md-3">${orders.FK_persons}</div>

                  </div>
               </c:forEach>

<br><br>(${ordersCount})
<t:paginator step="10" count="${ordersCount}" urlprefix="?startNumber="/>

<%@ include file="include/end-html.jsp" %>