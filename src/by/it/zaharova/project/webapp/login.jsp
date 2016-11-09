<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


    <form class="form-horizontal" action="do?command=LOGIN" method="POST">
    <fieldset>

    <!-- Form Name -->
    <legend>Вход</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="ID">ID</label>
      <div class="col-md-4">
      <input id="ID" name="ID" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">не обязательно</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Name_surname">Фамилия Имя</label>
      <div class="col-md-4">
      <input id="Name_surname" name="Name_surname" type="text" placeholder="Иванов Алексей" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Phone_number">Номер телефона</label>
      <div class="col-md-4">
      <input id="Phone_number" name="Phone_number" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Speciality">Специальность</label>
      <div class="col-md-4">
      <input id="Speciality" name="Speciality" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Cabinet">Кабинет</label>
      <div class="col-md-4">
      <input id="Cabinet" name="Cabinet" type="text" placeholder="" class="form-control input-md">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Вход</button>
      </div>
    </div>

    </fieldset>
    </form>

<%@ include file="include/end-html.jsp" %>
