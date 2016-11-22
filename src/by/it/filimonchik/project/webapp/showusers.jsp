<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="include/begin-html.jsp" %>


<legend>Все пользователи</legend>
   <div class="row">
        <div class=col-md-3>ID</div>
        <div class=col-md-3>Name</div>
        <div class=col-md-3>Password</div>
        <div class=col-md-3>Email</div>
   </div>
   <br>
    <c:forEach items="${usersList}" var="user">
             <br />
             <div class="row">
             <div class="col-md-3">${user.ID} </div>
             <div class="col-md-3">${user.login}</div>
             <div class="col-md-3">${user.password}</div>
             <div class="col-md-3">${user.email}</div>
             </div>
    </tr>
    </c:forEach>
        <br><br>
        <t:paginator step="5" count="${adCount}" urlprefix="do?command=ShowUsers&startNumber="/>
</table>
<%@ include file="include/end-html.jsp" %>