<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="POST">
<fieldset>

<!—Регистрация пользователя -->
<legend>Регистрация пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Логин</label>  
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="login" class="form-control input-md">
  <span class="help-block">Введите логин</span>  
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Пароль</label>
  <div class="col-md-4">
    <input id="Password" name="Password" type="text" placeholder="password" class="form-control input-md">
    <span class="help-block">Введите пароль</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Имя</label>  
  <div class="col-md-4">
  <input id="Name" name="Name" type="text" placeholder="имя" class="form-control input-md">
  <span class="help-block">Введите ваше имя</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Фамилия</label>  
  <div class="col-md-4">
  <input id="Surname" name="Surname" type="text" placeholder="фамилия" class="form-control input-md">
  <span class="help-block">Введите вашу фамилию</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Дата рождения</label>  
  <div class="col-md-4">
  <input id="Birthday" name="Birthday" type="text" placeholder="гггг-мм-дд" class="form-control input-md">
  <span class="help-block">Введите дату рождения</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Город</label>  
  <div class="col-md-4">
  <input id="City" name="City" type="text" placeholder="город" class="form-control input-md">
  <span class="help-block">Введите город</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Улица</label>  
  <div class="col-md-4">
  <input id="Street" name="Street" type="text" placeholder="улица" class="form-control input-md">
  <span class="help-block">Введите улицу</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Дом</label>  
  <div class="col-md-4">
  <input id="House" name="House" type="text" placeholder="дом" class="form-control input-md">
  <span class="help-block">Введите дом</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Квартира</label>  
  <div class="col-md-4">
  <input id="Flat" name="Flat" type="text" placeholder="квартира" class="form-control input-md">
  <span class="help-block">Введите квартиру</span>  
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрироваться</button>
  </div>
</div>

<br>
<br>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
