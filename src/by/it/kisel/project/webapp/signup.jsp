<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="post">
<fieldset>

<!-- Form Name -->
<legend>Зарегистрироваться</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ID">ID</label>
  <div class="col-md-4">
  <input id="ID" name="ID" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">не требуется</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="FirstName">Имя</label>
  <div class="col-md-4">
  <input id="FirstName" name="FirstName" type="text" placeholder="Ivan" class="form-control input-md">
  <span class="help-block">Введите ваше имя</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="SecondName">Фамилия</label>
  <div class="col-md-4">
  <input id="SecondName" name="SecondName" type="text" placeholder="Ivanov" class="form-control input-md">
  <span class="help-block">Введите вашу фамилию</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="PhoneNumber">Номер телефона</label>
  <div class="col-md-4">
  <input id="PhoneNumber" name="PhoneNumber" type="text" placeholder="+375295550055" class="form-control input-md">
  <span class="help-block">Введите ваш номер телефона</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">Email</label>
  <div class="col-md-4">
  <input id="Email" name="Email" type="text" placeholder="email" class="form-control input-md">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="role">Роль</label>
  <div class="col-md-4">
    <select id="role" name="FK_role" class="form-control">
      <option value="1">Administrator</option>
      <option value="2">User</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Single Button"></label>
  <div class="col-md-4">
    <button id="Single Button" name="Single Button" class="btn btn-primary">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
