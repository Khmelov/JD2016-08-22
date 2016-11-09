
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<div class="page-header">
    <h3 align="center">Flight time-table</h3>
</div>

<div class="container">

    <div class="panel panel-warning">
        <div class="panel-heading">Find panel</div>
        <div class="panel-body">
            <div class="row">
                <form class="form-find" action="airport?command=index" method=POST>
                   <!-- Select Basic -->
                    <div class="col-md-2">
                        <select id="from" name="from"  class="form-control">
                            <option value="" selected disabled>Departure</option>
                            <c:forEach items="${airports}" var="airport">
                                <option value=${airport.id}>${airport.acronim}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <!-- Select Basic -->
                    <div class="col-md-2">
                        <select id="to" name="to" class="form-control">
                            <option value="" selected disabled>Destination</option>
                            <c:forEach items="${airports}" var="airport">
                                <option value=${airport.id}>${airport.acronim}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <%--<div class=col-md-1>Departure time</div>--%>
                    <div class=col-md-2>
                        <input name="departureTime" size="16" type="text" value="" placeholder="Departure time" class="form_datetime">
                    </div>

                    <%--<div class=col-md-1>Arrival time</div>--%>
                    <div class=col-md-2>
                        <input name="arrivalTime" size="16" type="text" value="" placeholder="Arrival time" class="form_datetime">
                    </div>
                    <!-- Button -->
                    <div class="col-md-2">
                        <button id="singlebutton" class="btn btn-success">Find</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <table class="table table-hover">
        <thead>
        <tr>
            <th>Code</th>
            <th>Company</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>Plane</th>
            <th>From</th>
            <th>To</th>

            <c:if test="${user.role<3}">
                <th>Crew</th>
                <th>User</th>
            </c:if>

        </tr>
        </thead>
        <tbody>
            <c:forEach items="${flights}" var="flight">
                <tr>
                <td>${flight.flightCode} </td>
                <td>${flight.company}</td>
                <td>${flight.departure_time}</td>
                <td>${flight.arrival_time}</td>
                <td>${flight.plane}</td>
                <td>${flight.from}</td>
                <td>${flight.to}</td>
                <c:if test="${user.role<3}">
                    <td>${flight.crew}</td>
                    <td>${flight.user}</td>
                </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>

    <br>(${adCount})
    <t:paginator step="10" count="${adCount}" urlprefix="?startNumber="/>

    </fieldset>
    </form>


<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>

<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd',
        minView: 2,
        pickTime: false
    });

</script>


<%@ include file="include/end-html.jsp" %>