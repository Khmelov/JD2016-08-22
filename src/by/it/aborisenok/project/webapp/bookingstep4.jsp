<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=GETTALON" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Время визита</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Время визита</label>
  <div class="col-md-4">
    <select id="Time" name="Time" class="form-control">
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
