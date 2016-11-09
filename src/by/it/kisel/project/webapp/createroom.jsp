<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

   <form class="form-horizontal" action="do?command=CreateRoom" method="post">
   <fieldset>

   <!-- Form Name -->
   <legend>Добавить комнату</legend>

   <!-- Multiple Checkboxes (inline) -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="RoomCount">Количество комнат</label>
     <div class="col-md-4">
       <label class="checkbox-inline" for="RoomCount-0">
         <input type="checkbox" name="RoomCount" id="RoomCount-0" value="1">
         1
       </label>
       <label class="checkbox-inline" for="RoomCount-1">
         <input type="checkbox" name="RoomCount" id="RoomCount-1" value="2">
         2
       </label>
       <label class="checkbox-inline" for="RoomCount-2">
         <input type="checkbox" name="RoomCount" id="RoomCount-2" value="3">
         3
       </label>
       <label class="checkbox-inline" for="RoomCount-3">
         <input type="checkbox" name="RoomCount" id="RoomCount-3" value="4">
         4
       </label>
     </div>
   </div>

   <!-- Select Basic -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="Quality">Качество</label>
     <div class="col-md-4">
       <select id="Quality" name="Quality" class="form-control">
         <option value="1">1</option>
         <option value="2">2</option>
         <option value="3">3</option>
         <option value="4">4</option>
         <option value="5">5</option>
         <option value="6">6</option>
         <option value="7">7</option>
         <option value="8">8</option>
         <option value="9">9</option>
         <option value="10">10</option>
       </select>
     </div>
   </div>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="PriceForDay">Цена за день</label>
     <div class="col-md-4">
     <input id="PriceForDay" name="PriceForDay" type="text" placeholder="" class="form-control input-md">

     </div>
   </div>

   <!-- Multiple Checkboxes -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="Conditioner">Кондиционер</label>
     <div class="col-md-4">
     <div class="checkbox">
       <label for="Conditioner-0">
         <input type="checkbox" name="Conditioner" id="Conditioner-0" value="Yes">
         Да
       </label>
   	</div>
     <div class="checkbox">
       <label for="Conditioner-1">
         <input type="checkbox" name="Conditioner" id="Conditioner-1" value="No">
         Нет
       </label>
   	</div>
     </div>
   </div>

   <!-- Textarea -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="Description">Описание</label>
     <div class="col-md-4">
       <textarea class="form-control" id="Description" name="Description">Краткое описание комнаты</textarea>
     </div>
   </div>

   <!-- Button -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="singlebutton"></label>
     <div class="col-md-4">
       <button id="singlebutton" name="singlebutton" class="btn btn-primary">Добавить</button>
     </div>
   </div>

   </fieldset>
   </form>


<%@ include file="include/end-html.jsp" %>
