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
    <select id="FK_Model" name="FK_Model" class="form-control">

      <option value="Renault">Renault</option>
      <option selected value="Mazda">Mazda</option>
      <option value="Jaguar">Jaguar</option>
      <option value="Audi">Audi</option>
      <option value="Jeep">Jeep</option>
      <option value="Porsche">Porsche</option>
      <option value="Nissan">Nissan</option>
    </select>
    <span class="help-block">Select the model</span>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Car_body">Car body style</label>
  <div class="col-md-4">
         <input id="FK_Car_body" name="FK_Car_body" type="text" placeholder="" value="" class="form-control input-md" required="">
    <span class="help-block">Type the car body style</span>
  </div>
</div>

<!-- Textarea
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Color">Color</label>
  <div class="col-md-4">
     <input id="FK_Color" name="FK_Color" type="text" placeholder="" value="" class="form-control input-md" required="">
    <span class="help-block">Type the color</span>
  </div>
</div>-->

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_Color">Color</label>
  <div class="col-md-4">
    <label class="radio-inline" for="FK_Color-0">
      <input type="radio" name="FK_Color" id="FK_Color-0" value="White" >
      White
    </label>
    <label class="radio-inline" for="FK_Color-1">
      <input type="radio" name="FK_Color" id="FK_Color-1" value="Black" checked="checked">
      Black
    </label>
    <label class="radio-inline" for="FK_Color-2">
      <input type="radio" name="FK_Color" id="FK_Color-2" value="Grey">
      Grey
    </label>
    <label class="radio-inline" for="FK_Color-3">
      <input type="radio" name="FK_Color" id="FK_Color-3" value="Red">
      Red
    </label>
        <label class="radio-inline" for="FK_Color-4">
          <input type="radio" name="FK_Color" id="FK_Color-4" value="Yellow">
          Yellow
        </label>
    <span class="help-block">Select the color</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Price</label>
  <div class="col-md-4">
  <input id="Price" name="Price" type="text" placeholder="" value="" class="form-control input-md" required="">
  <span class="help-block">Type the price in USD</span>
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
