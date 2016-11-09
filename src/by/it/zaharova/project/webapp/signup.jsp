<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="post">
<fieldset>

<!-- Form Name -->
<legend>Регистрация пациента</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ID">ID</label>
  <div class="col-md-4">
  <input id="ID" name="ID" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">не обязательно</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="First_name">Имя</label>
  <div class="col-md-4">
  <input id="First_name" name="First_name" type="text" placeholder="Антошка" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Second_name">Фамилия</label>
  <div class="col-md-4">
  <input id="Second_name" name="Second_name" type="text" placeholder="Иванов" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Address">Адрес</label>
  <div class="col-md-4">
  <input id="Address" name="Address" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Phone_number">Номер телефона</label>
  <div class="col-md-4">
  <input id="Phone_number" name="Phone_number" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_doctors">ID доктора </label>
  <div class="col-md-4">
  <input id="FK_doctors" name="FK_doctors" type="text" placeholder="" class="form-control input-md">

  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>



<%@ include file="include/end-html.jsp" %>
