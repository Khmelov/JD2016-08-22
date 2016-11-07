<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=SIGNUP" method="post">
    <fieldset>
        <!-- Form Name -->
        <legend>Регистрация нового пользователя</legend>
        <!-- Name input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="Name">Имя</label>
                    <div class="col-md-4">
                        <input id="Name" name="Name" type="text" value="UserName" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">Введите Ваше имя</span>
                    </div>
                </div>
        <!-- Surname input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Surname">Фамилия</label>
            <div class="col-md-4">
                <input id="Surname" name="Surname" type="text" value="UserSurname" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Вашу Фамилию</span>
            </div>
        </div>
        <!-- Login input-->
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
                <span class="help-block">Введите пароль не менее 8 символов</span>
            </div>
        </div>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Email">E-mail</label>
            <div class="col-md-4">
                <input id="Email" name="Email" type="text" value="email@gmail.com" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите E-mail</span>
            </div>
        </div>
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
            </div>
        </div>
    </fieldset>
</form>
<%@ include file="include/end-html.jsp" %>
