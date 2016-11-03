<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">

<fieldset>

<!-- Form Name -->
<legend>Вход на сайт</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Логин</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="login" class="form-control input-md">
  <span class="help-block">Введите ваш логин</span>  
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Пароль</label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" type="password" placeholder="password" class="form-control input-md">
    <span class="help-block">Введите пароль</span>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button1id"></label>
  <div class="col-md-8">
  <form class="form-horizontal">
    <button id="button1id" name="button1id" class="btn btn-success" formaction="do?command=SIGNIN" method="POST">Войти</button>
    <button id="button2id" name="button2id" class="btn btn-success" formaction="do?command=SIGNUP" method="GET">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
