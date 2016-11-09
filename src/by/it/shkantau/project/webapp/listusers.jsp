
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="container">

<div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-2>Login</div>
        <div class=col-md-2>Password</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Role</div>
    </b>
</div>
<br>
<!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
<c:forEach items="${users}" var="user">
    <div class="row">
        <form class="form-user-${user.id}" action="airport?command=ListUsers" method=POST>
            <div class=col-md-1>
                <input id="user_id_${user.id}" name="ID" type="text"
                       value="${user.id}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Login" type="text"
                       value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Password" type="text"
                       value="${user.pass}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Email" type="text"
                       value="${user.email}" class="form-control input-md">
            </div>

            <div class=col-md-2>
                <select id="role" name="fk_Role" class="form-control">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.id}" role=${role.id} ${role.id==user.role?"selected":""}>
                                ${role.role}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class=col-md-1>
                <button id="singlebutton1" name="singlebutton1" class="btn btn-success">
                    Update
                </button>
            </div>

            <div class=col-md-1>
                <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                        onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                >
                    Delete
                </button>
            </div>

        </form>
    </div>
    <br>
</c:forEach>

</div>

<%--<table width="100%" border="1" cellpadding="1" cellspacing="1">--%>
    <%--<tr>--%>
        <%--<th scope="col" bgcolor="#a9a9a9" align="center">LOGIN</th>--%>
        <%--<th scope="col" bgcolor="#a9a9a9" align="center">EMAIL</th>--%>
        <%--<th scope="col" bgcolor="#a9a9a9" align="center">ROLE</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${users}" var="user">--%>
        <%--<tr>--%>
            <%--<td align="center"> ${user.login}</td>--%>
            <%--<td align="center">${user.email}</td>--%>
            <%--&lt;%&ndash;<td align="center">${roles.get(${user.role})}</td>&ndash;%&gt;--%>
            <%--<c:choose>--%>
                <%--<c:when test="${user.role==1}">--%>
                    <%--<td align="center">Administrator</td>--%>
                <%--</c:when>--%>
                <%--<c:when test="${user.role==2}">--%>
                    <%--<td align="center">Dispatcher</td>--%>
                <%--</c:when>--%>
                <%--<c:when test="${user.role==3}">--%>
                    <%--<td align="center">User</td>--%>
                <%--</c:when>--%>
            <%--</c:choose>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<%@ include file="include/end-html.jsp" %>
