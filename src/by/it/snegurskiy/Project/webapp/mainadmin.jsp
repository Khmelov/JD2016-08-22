<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-1>Фамилия</div>
        <div class=col-md-1>Имя</div>
        <div class=col-md-1>Логин</div>
        <div class=col-md-1>Пароль</div>
        <div class=col-md-1>Роль</div>
        <div class=col-md-1>Статус</div>
    </b>
   </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
   <c:forEach items="${users}" var="user">
        <div class="row">
        <form class="form-user-${user.ID}" action="do?command=MAINADMIN" method=POST>
            <div class=col-md-1>
                <input id="user_id_${user.ID}" name="ID" type="text"
                value="${user.ID}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                            <input id="textinput" name="Surname" type="text"
                            value="${user.surname}" class="form-control input-md">
                        </div>
            <div class=col-md-1>
                            <input id="textinput" name="Name" type="text"
                            value="${user.name}" class="form-control input-md">
                        </div>
            <div class=col-md-1>
                <input id="textinput" name="Login" type="text"
                value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                <input id="textinput" name="Password" type="text"
                value="${user.password}" class="form-control input-md">
            </div>
            <div class=col-md-1>
                    <select id="role" name="FK_Role" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.FK_Role?"selected":""}>
                                 ${role.role}
                            </option>
                        </c:forEach>
                    </select>
            </div>
            <div class=col-md-2>
                    <select id="role" name="FK_Status" class="form-control">
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.id}" status=${status.id} ${status.id==user.FK_Status?"selected":""}>
                                 ${status.status}
                            </option>
                        </c:forEach>
                    </select>
            </div>

                        <div class=col-md-1>
                <button id="singlebutton" name="singlebutton"
                class="btn btn-danger"
                onclick="document.getElementById('user_id_${user.ID}').value=-document.getElementById('user_id_${user.ID}').value;"
                >
                    Поменять статус
                </button>
            </div>

        </form>
        </div>
   <br>
   </c:forEach>
   и т.д.

<%@ include file="include/end-html.jsp" %>
