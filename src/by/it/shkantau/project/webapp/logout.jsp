<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="airport?command=LOGOUT" method="POST">

   <fieldset>

        <!-- Form Name -->
        <legend align="center">Logout</legend>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" value="1" class="btn btn-success">Logout</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
