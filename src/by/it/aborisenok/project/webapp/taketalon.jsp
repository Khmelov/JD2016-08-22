<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=BOOKINGSTEP1" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Заказ талона</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Приступить к заказу</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
