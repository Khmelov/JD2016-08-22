<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



   <form class="form-horizontal" action="do?command=CreateOrder" method="post">
   <fieldset>

   <!-- Form Name -->
   <legend>Сделать заказ</legend>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="ArrivalDate">День заселения</label>
     <div class="col-md-4">
     <input id="ArrivalDate" name="ArrivalDate" type="text" placeholder="" class="form-control input-md">

     </div>
   </div>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="DepartureDate">День выселения</label>
     <div class="col-md-4">
     <input id="DepartureDate" name="DepartureDate" type="text" placeholder="" class="form-control input-md">

     </div>
   </div>

   <!-- Text input-->
   <div class="form-group">
      <label class="col-md-4 control-label" for="TotalPrice">Цена</label>
      <div class="col-md-4">
      <input id="TotalPrice" name="TotalPrice" type="text" placeholder="" class="form-control input-md">
      </div>
   </div>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="FK_rooms">ID комнаты</label>
     <div class="col-md-4">
     <input id="FK_rooms" name="FK_rooms" type="text" placeholder="" class="form-control input-md">

     </div>
   </div>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="FK_persons">ID заказчика</label>
     <div class="col-md-4">
     <input id="FK_persons" name="FK_persons" type="text" placeholder="" class="form-control input-md">

     </div>
   </div>

   <!-- Button -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="singlebutton"></label>
     <div class="col-md-4">
       <button id="singlebutton" name="singlebutton" class="btn btn-primary">Готово</button>
     </div>
   </div>

   </fieldset>
   </form>



<%@ include file="include/end-html.jsp" %>
