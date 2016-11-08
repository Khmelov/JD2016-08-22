<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<table width="100%" >
   <tr>

<th>
    1
</th>

<th>
    <form class="form-horizontal" action="do?command=DOWNLOAD" method="GET">
    <fieldset>
    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-success">Скачать</button>
      </div>
    </div>
    </fieldset>
    </form>
</th>

<th>
    <form class="form-horizontal" action="do?command=DELETE" method="POST">
    <fieldset>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-success">Удалить</button>
      </div>
    </div>
    </fieldset>
    </form>
</th>

<th>
    <form class="form-horizontal" action="do?command=BOOKINGSTEP1" method="GET">
    <fieldset>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-success">Заказать талон</button>
      </div>
    </div>
    </fieldset>
    </form>
</th>

   </tr>

 </table>



<%@ include file="include/end-html.jsp" %>
