<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEAD" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавить объявление</legend>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Model">Model</label>
  <div class="col-md-4">
  <input id="FK_Model" name="FK_Model" type="text" placeholder="" value="Audi" class="form-control input-md" required="">
  <span class="help-block">Type the model</span>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Car_body">Car body</label>
  <div class="col-md-4">
         <input id="FK_Car_body" name="FK_Car_body" type="text" placeholder="" value="" class="form-control input-md" required="">
    <span class="help-block">Type the car body</span>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Color">Color</label>
  <div class="col-md-4">
     <input id="FK_Color" name="FK_Color" type="text" placeholder="" value="" class="form-control input-md" required="">
    <span class="help-block">Type the color</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Price</label>
  <div class="col-md-4">
  <input id="Price" name="Price" type="text" placeholder="" value="100" class="form-control input-md" required="">
  <span class="help-block">Type the price U.S</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Done</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
