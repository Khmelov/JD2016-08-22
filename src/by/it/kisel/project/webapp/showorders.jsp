<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

     <div class="row">
         <b>
             <div class=col-md-1>ID</div>
             <div class=col-md-2>Дата заселения</div>
             <div class=col-md-2>Дата выселения</div>
             <div class=col-md-2>Цена</div>
             <div class=col-md-1>ID комнаты</div>
             <div class=col-md-1>ID заказчика</div>
         </b>
        </div>
        <br>
        <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
        <c:forEach items="${orderss}" var="orders">
             <div class="row">
             <form class="form-orders-${orders.ID}" action="do?command=ShowOrders" method=POST>
                 <div class=col-md-1>
                     <input id="orders_id_${orders.ID}" name="ID" type="text"
                     value="${orders.ID}" class="form-control input-md">
                 </div>
                 <div class=col-md-2>
                     <input id="textinput" name="ArrivalDate" type="text"
                     value="${orders.arrivalDate}" class="form-control input-md">
                 </div>
                 <div class=col-md-2>
                     <input id="textinput" name="DepartureDate" type="text"
                     value="${orders.departureDate}" class="form-control input-md">
                 </div>
                 <div class=col-md-2>
                     <input id="textinput" name="TotalPrice" type="text"
                     value="${orders.totalPrice}" class="form-control input-md">
                  </div>
                 <div class=col-md-1>

                     <input id="textinput" name="FK_rooms" type="text"
                     value="${orders.FK_rooms}" class="form-control input-md">

                 </div>
                 <div class=col-md-1>

                     <input id="textinput" name="FK_persons" type="text"
                     value="${orders.FK_persons}" class="form-control input-md">

                 </div>


                 <div class=col-md-1>
                     <button id="singlebutton" name="singlebutton" class="btn btn-success">
                         Обновить
                     </button>
                 </div>
     
                 <div class=col-md-1>
                     <button id="singlebutton" name="singlebutton"
                     class="btn btn-danger"
                     onclick="document.getElementById('orders_id_${orders.ID}').value=-document.getElementById('orders_id_${orders.ID}').value;"
                     >
                         Удалить
                     </button>
                 </div>
     
             </form>
             </div>
        <br>
     </c:forEach>


<%@ include file="include/end-html.jsp" %>