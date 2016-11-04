<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CreateAD" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Создать объявление</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="id">Цена</label>
            <div class="col-md-4">
                <input id="id" name="ID" value="0" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите стоимость</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Адрес</label>
            <div class="col-md-4">
                <input id="login" name="Login" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Улица и дом</span>
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Этаж</label>
            <div class="col-md-4">
                <input id="email" name="Email" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите этаж</span>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Этажность</label>
            <div class="col-md-4">
                <select id="role" name="FK_role" class="form-control">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Опубликовать</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
