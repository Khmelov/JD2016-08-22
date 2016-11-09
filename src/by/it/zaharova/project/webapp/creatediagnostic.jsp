<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



   <form class="form-horizontal" action="do?command=CreateDiagnostic" method="post">
<fieldset>

<!-- Form Name -->
<legend>Добавить диагноз</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Illness">Диагноз</label>
  <div class="col-md-4">
  <input id="Illness" name="Illness" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Drugs">Прописанные препараты</label>
  <div class="col-md-4">
  <input id="Drugs" name="Drugs" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Multiple Checkboxes -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Operations">Необходимость операции</label>
  <div class="col-md-4">
  <div class="checkbox">
    <label for="Operations-0">
      <input type="checkbox" name="Operations" id="Operations-0" value="1">
      Да
    </label>
	</div>
  <div class="checkbox">
    <label for="Operations-1">
      <input type="checkbox" name="Operations" id="Operations-1" value="2">
      Нет
    </label>
	</div>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Procedures">Назначенные процедуры</label>
  <div class="col-md-4">
  <input id="Procedures" name="Procedures" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_patients">ID пациентов</label>
  <div class="col-md-4">
  <input id="FK_patients" name="FK_patients" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="FK_doctors">ID доктора</label>
  <div class="col-md-4">
  <input id="FK_doctors" name="FK_doctors" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

 <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Готово</button>
      </div>
    </div>

</fieldset>
</form>



<%@ include file="include/end-html.jsp" %>
