
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal" action="airport?command=Index" method="POST">
    <fieldset>

        <table width="100%" border="1" cellpadding="2" cellspacing="2">
            <tbody>
            <tr>
                <th scope="col" bgcolor="#a9a9a9" align="center">Code</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">Company</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">Departure Time</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">Arrival Time</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">Plane</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">From</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">To</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">Crew</th>
                <th scope="col" bgcolor="#a9a9a9" align="center">User</th>
            </tr>

            <c:forEach items="${flights}" var="flight">
                <tr>
                    <td align="center"> ${flight.flightCode}</td>
                    <td align="center">${flight.company}</td>
                    <td align="center">${flight.departure_time}</td>
                    <td align="center">${flight.arrival_time}</td>
                    <td align="center">${flight.plane}</td>
                    <td align="center">${flight.to}</td>
                    <td align="center">${flight.from}</td>
                    <td align="center">${flight.crew}</td>
                    <td align="center">${flight.user}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br/>
        <br/>

        <!-- Button -->
        <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="singlebutton"></label>--%>
            <%--<div class="col-md-4">--%>
                <%--<button id="singlebutton" class="btn btn-success">Refresh</button>--%>
            <%--</div>--%>
        <%--</div>--%>

    </fieldset>
</form>





<%@ include file="include/end-html.jsp" %>