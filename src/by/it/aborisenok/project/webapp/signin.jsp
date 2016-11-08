<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNIN" method="POST">

<fieldset>

<!-- Form Name -->
<legend>Вход на сайт</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Логин</label>  
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="login" class="form-control input-md">
  <span class="help-block">Введите ваш логин</span>  
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Пароль</label>
  <div class="col-md-4">
    <input id="Password" name="Password" type="password" placeholder="password" class="form-control input-md">
    <span class="help-block">Введите пароль</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
