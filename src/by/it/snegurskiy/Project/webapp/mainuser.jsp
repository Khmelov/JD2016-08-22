<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-1>Фамилия</div>
        <div class=col-md-1>Имя</div>
        <div class=col-md-1>Логин</div>
        <div class=col-md-1>Пароль</div>

    </b>
   </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
   <c:forEach items="${users}" var="user">
        <div class="row">
        <form class="form-user-${user.ID}" action="do?command=MAINUSER" method=POST>
            <div class=col-md-1>
                <input id="user_id_${user.ID}" name="ID" type="text"
                value="${user.ID}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                            <input id="textinput" name="Surname" type="text"
                            value="${user.surname}" class="form-control input-md">
                        </div>
            <div class=col-md-1>
                            <input id="textinput" name="Name" type="text"
                            value="${user.name}" class="form-control input-md">
                        </div>
            <div class=col-md-1>
                <input id="textinput" name="Login" type="text"
                value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="textinput" name="Password" type="text"
                value="${user.password}" class="form-control input-md">
            </div>


        </form>
        </div>
   <br>
   </c:forEach>

<p>Актуальные счета</p>

<div class="row">
    <b>
        <div class=col-md-2>ID/Номер счета</div>
        <div class=col-md-1>Баланс</div>


    </b>
   </div>
   <br>

   <c:forEach items="${accounts}" var="account">
        <div class="row">
        <form class="form-account-${account.ID}" action="do?command=MAINUSER" method=POST>
            <div class=col-md-2>
                <input id="account_id_${account.ID}" name="ID" type="text"
                value="${account.ID}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                            <input id="textinput" name="Balance" type="text"
                            value="${account.balance}" class="form-control input-md">
                        </div>

        </form>
        </div>
   <br>
   </c:forEach>

<form action="do?command=MAINUSER" method="post">
<div class="form-group">
            <label class="col-md-1 control-label" for="singlebutton"></label>
            <div class="col-md-1">
                <button id="singlebutton" name="button1" class="btn btn-success">Создать новый счет</button>
            </div>
        </div><br>
        <div class="form-group">
                    <label class="col-md-1 control-label" for="singlebutton"></label>
                    <div class="col-md-1">
                        <button id="singlebutton" name="button2" class="btn btn-success">Совершите платеж</button>
                    </div>
                </div><br>
                <div class="form-group">
                            <label class="col-md-1 control-label" for="singlebutton"></label>
                            <div class="col-md-1">
                                <button id="singlebutton" name="button4" class="btn btn-success">Положить деньги</button>
                            </div>
                        </div><br>

</form>


<%@ include file="include/end-html.jsp" %>
