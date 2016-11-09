<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

    <!-- Основное содержимое -->
          <div class="page-header">
            <h1>Статус заказа</h1>

          </div>

                 <div class="row">
                   <div class="col-md-1">№</div>
                   <div class="col-md-2">Номер заказа</div>
                   <div class="col-md-4">Статус заказа</div>

                 </div>
              <% Integer i=0; %>
              <c:forEach items="${statuss}" var="status">
                 <br />
                 <div class="row">
                   <div class="col-md-1"><% out.print(++i); %></div>
                   <div class="col-md-2">${status.FK_orders} </div>
                   <div class="col-md-4">${status.orderStatus}</div>


                 </div>
              </c:forEach>
<br><br>(${statusCount})
<t:paginator step="10" count="${statusCount}" urlprefix="?startNumber="/>

<%@ include file="include/end-html.jsp" %>