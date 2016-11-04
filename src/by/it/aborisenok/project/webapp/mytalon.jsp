<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

????????????????????

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button1id">Мой талон</label>
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success" formaction="do?command=DOWNLOAD" method="GET">Скачать</button>
    <button id="button2id" name="button2id" class="btn btn-danger" formaction="do?command=DELETE" method="POST">Удалить</button>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success" formaction="do?command=BOOKINGSTEP1" method="GET">Заказать талон</button>
  </div>
</div> 

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
