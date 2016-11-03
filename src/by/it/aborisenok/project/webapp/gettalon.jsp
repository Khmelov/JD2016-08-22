<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

????????????????????

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="buttondownload"></label>
  <div class="col-md-4">
    <button id="buttondownload" name="buttondownload" class="btn btn-primary" formaction="do?command=DOWNLOAD" method="GET">Скачать талон</button>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="buttonmytalons"></label>
  <div class="col-md-4">
    <button id="buttonmytalons" name="buttonmytalons" class="btn btn-success" formaction="do?command=MYTALON" method="GET">Мои талоны</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
