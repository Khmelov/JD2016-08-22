<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="POST">
<fieldset>

<!—Регистрация пользователя -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Логин</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="login" class="form-control input-md">
  <span class="help-block">Введите логин</span>  
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

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Имя</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="имя" class="form-control input-md">
  <span class="help-block">Введите ваше имя</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Фамилия</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="фамилия" class="form-control input-md">
  <span class="help-block">Введите вашу фамилию</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Дата рождения</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="гггг.мм.дд" class="form-control input-md">
  <span class="help-block">Введите дату рождения</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Город</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="город" class="form-control input-md">
  <span class="help-block">Введите город</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Улица</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="улица" class="form-control input-md">
  <span class="help-block">Введите улицу</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Дом</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="дом" class="form-control input-md">
  <span class="help-block">Введите дом</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Квартира</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="квартира" class="form-control input-md">
  <span class="help-block">Введите квартиру</span>  
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
