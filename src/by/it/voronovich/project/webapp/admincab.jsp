<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/begin-html.jsp" %>
<div class="row">
    <div class="col-md-1"><b><h4>ID</b></h4></div>
    <div class="col-md-1"><b><h4>Name</b></h4></div>
    <div class="col-md-1"><b><h4>Surname</b></h4></div>
    <div class="col-md-1"><b><h4>Login</b></h4></div>
    <div class="col-md-1"><b><h4>Password</b></h4></div>
    <div class="col-md-2"><b><h4>E-mail</b></h4></div>
    <div class="col-md-1"><b><h4>Role</b></h4></div>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>
</div>
<hr align="left" width="1100" size="9" color="#ff9900" />
    <c:forEach var="user" items="${userList}">
        <form class="form-horizontal" action="do?command=ADMINCAB" method="post">
            <fieldset>
                <div class="row">
                    <div class="col-md-1"><input id="idUsers${user.getIdUsers()}" name="idUsers" value="${user.getIdUsers()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Name" name="Name" value="${user.getName()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Surname" name="Surname" value="${user.getSurname()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Login" name="Login" value="${user.getLogin()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Password" name="Password" value="${user.getPassword()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-2"><input id="Email" name="Email" value="${user.getEmail()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="FK_Role" name="FK_Role" value="${user.getFK_Role()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-2">
                        <!-- Button -->
                            <label class="col-md-2 control-label" for="singlebutton"></label>
                                <div class="col-md-2">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Обновить</button>
                                </div>
                    </div>
                    <div class="col-md-2">
                        <!-- Button -->
                            <label class="col-md-2 control-label" for="singlebutton"></label>
                                <div class="col-md-2">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                                     onclick="document.getElementById('idUsers${user.getIdUsers()}').value=-document.getElementById('idUsers${user.getIdUsers()}').value;"
                                    >Удаалить</button>
                                </div>
                    </div>
                </div>
                <hr align="left" width="1100" size="9" color="#ff9900" />
            </fieldset>
        </form>
    </c:forEach>
<%@ include file="include/end-html.jsp" %>