<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<table align="center" border="1" width="30%">
  <tr>
    <td align="center">${message}</td>
  </tr>
</table>
<br>
<br>
<table align="center"  width="60%">
  <tr>

    <td align="center">
    <form class="form-horizontal" action="do?command=DOWNLOAD" method="GET">
    <fieldset>

    <!-- Form Name -->

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="buttondownload"></label>
      <div class="col-md-4">
        <button id="buttondownload" name="buttondownload" class="btn btn-success">Скачать талон</button>
      </div>
    </div>

    </fieldset>
    </form>
    </td>


    <td align="center">
    <form class="form-horizontal" action="do?command=MYTALON" method="POST">
    <fieldset>

    <!-- Form Name -->

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="buttonmytalons"></label>
      <div class="col-md-4">
        <button id="buttonmytalons" name="buttonmytalons" class="btn btn-success">Мои талоны</button>
      </div>
    </div>

    </fieldset>
    </form>
    </td>

  </tr>
</table>







<%@ include file="include/end-html.jsp" %>
