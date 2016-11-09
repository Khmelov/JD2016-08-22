<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



   <form class="form-horizontal" action="do?command=CreateStatus" method="post">
   <fieldset>

   <!-- Form Name -->
   <legend>Обновить статус</legend>

   <!-- Text input-->
         <div class="form-group">
           <label class="col-md-4 control-label" for="FK_orders">ID заказа</label>
           <div class="col-md-4">
           <input id="FK_orders" name="FK_orders" type="text" placeholder="" class="form-control input-md">

           </div>
         </div>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="OrderStatus">Статус заказа</label>
     <div class="col-md-4">
     <input id="OrderStatus" name="OrderStatus" type="text" placeholder="" class="form-control input-md">

     </div>
   </div>



   <!-- Button -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="singlebutton"></label>
     <div class="col-md-4">
       <button id="singlebutton" name="singlebutton" class="btn btn-success">Обновить</button>
     </div>
   </div>

   </fieldset>
   </form>



<%@ include file="include/end-html.jsp" %>
