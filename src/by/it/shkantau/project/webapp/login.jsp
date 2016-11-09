
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="airport?command=LOGIN" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend align="center">Login Form</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login"  type="text" value="" placeholder="login" class="form-control input-md" required="">
                <%--<span class="help-block">Type your login</span>--%>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass">Password</label>
            <div class="col-md-4">
                <input id="pass" name="pass"  type="password" value="" placeholder="password" class="form-control input-md" required="">

                <%--<span class="help-block">Password</span>--%>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" class="btn btn-success">Login</button>
            </div>
        </div>

    </fieldset>
</form>


<%--<p>Cmd Login: ${message}</p>--%>

<%@ include file="include/end-html.jsp" %>