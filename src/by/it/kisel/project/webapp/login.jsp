<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


    <form class="form-horizontal" action="do?command=LOGIN" method="POST">
    <fieldset>

    <!-- Form Name -->
    <legend>Вход</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="FirstName">Имя</label>
      <div class="col-md-4">
      <input id="FirstName" name="FirstName" type="text" placeholder="Ivan" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Email">Email</label>
      <div class="col-md-4">
      <input id="Email" name="Email" type="text" placeholder="email" class="form-control input-md">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Login Button"></label>
      <div class="col-md-4">
        <button id="Login Button" name="Login Button" class="btn btn-success">Войти</button>
      </div>
    </div>

    </fieldset>
    </form>


<%@ include file="include/end-html.jsp" %>
