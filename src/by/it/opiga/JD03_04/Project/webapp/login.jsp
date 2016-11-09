<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=LOGIN" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Авторизация пользователя</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" value="UserLogin" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Пароль</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" value="UserPassword" placeholder="" class="form-control input-md" required="">
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
