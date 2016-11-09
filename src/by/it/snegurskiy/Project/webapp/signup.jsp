<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="post">
<fieldset>

<!-- Form Name -->
<p align="center">Регистрация пользователя</p>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="surname">Введите фамилию</label>
  <div class="col-md-4">
  <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Введите имя</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Введите логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Введите пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="OKreg"></label>
  <div class="col-md-4">
    <button id="OKreg" name="OKreg" class="btn btn-success">OK</button>
  </div>
</div>

<!-- Button -->

<div class="form-group">
                    <label class="col-md-4 control-label" for="registr"></label>
                    <div class="col-md-4">
                        <button id="registr" name="registr" class="btn btn-success"<li><a href="do?command=Login">Выйти</a></li></button>

                    </div>
                </div>


</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>


