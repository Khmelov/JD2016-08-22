<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



<form class="form-horizontal" action="do?command=DELETEUSER" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Список пользователей</legend>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectmultiple">Зарегистрированные пользователи</label>
  <div class="col-md-4">
    <select id="User" name="User" class="form-control" multiple="multiple" style="width: 500px;">
       ${message}
    </select>
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Удаление пользователя</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Удалить</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
