<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNOUT" method="GET">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Завершить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
