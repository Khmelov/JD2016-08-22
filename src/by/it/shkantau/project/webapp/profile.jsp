
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="airport?command=Profile" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend align="center">Sign-up</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login"  type="text" value= "<c:out value="${user.login}"/>"  placeholder="login" class="form-control input-md" required="Login can't be empty.">
             </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <input id="email" name="email"  type="text" value="<c:out value="${user.email}"/>" placeholder="email" class="form-control input-md" required="Email can't be empty.">
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pass">Password</label>
            <div class="col-md-4">
                <input id="pass" name="pass" type="password" value="<c:out value="${user.pass}"/>" placeholder="password" class="form-control input-md" required="Password can't be empty.">
            </div>
        </div>


        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Select role</label>
            <div class="col-md-4">
                <select id="role" name="role"  class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <option value=${role.id}>${role.role}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" class="btn btn-success">Create User</button>
            </div>
        </div>

    </fieldset>
</form>


<%@ include file="include/end-html.jsp" %>