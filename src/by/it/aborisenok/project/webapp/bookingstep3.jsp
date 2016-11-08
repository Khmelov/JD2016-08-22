<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=BOOKINGSTEP4" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Выбор доктора</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Список докторов</label>
  <div class="col-md-4">
    <select id="Name" name="Name" class="form-control">
       ${message}
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Далее</button>
  </div>
</div>
</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
