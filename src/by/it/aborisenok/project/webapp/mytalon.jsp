<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



<form class="form-horizontal" action="do?command=DELETE" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Мои талоны</legend>

<!-- Select Multiple -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectmultiple">Список талонов</label>
  <div class="col-md-4">
    <select id="Talon" name="Talon" class="form-control" multiple="multiple" style="width: 700px;">
       ${message}
    </select>
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Удалить талон</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Удалить</button>
  </div>
</div>

</fieldset>
</form>


<form class="form-horizontal" action="do?command=BOOKINGSTEP1" method="POST">
    <fieldset>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-success">Заказать ещё один талон</button>
      </div>
    </div>
    </fieldset>
    </form>


<%@ include file="include/end-html.jsp" %>
