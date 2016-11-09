<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CREATEARTICLE" method="POST">
    <fieldset>

    <!-- Form Name -->
    <legend>Добавить статью</legend>

    <div class="row">
        <input id="textinput" name="Title" type="text" value="Title" class="form-control input-md">
        <br>
        <textarea name="Info" class="form-control" rows="10" id="textinput">Text</textarea>
        <br>
        <div class="row">
            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Готово</button>
            </div>
        </div>
    </div>

    </fieldset>
</form>


<%@ include file="include/end-html.jsp" %>