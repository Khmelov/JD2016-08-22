<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNOUT" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Выйти из профиля</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Завершить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
