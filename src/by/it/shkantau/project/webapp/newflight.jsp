<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="airport?command=NewFlight" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Add Flight</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="code">Fligth Code</label>
            <div class="col-md-4">
                <input id="code" name="code"  type="text" placeholder="code"  class="form-control input-md" required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="company">Company</label>
            <div class="col-md-4">
                <input id="company" name="company"  type="text" placeholder="company" class="form-control input-md" required="">
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-4 control-label" >Departure & Arrival Time</label>
            <div class="container">
                <div class='col-md-2'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker6'>
                            <input name="departureTime" type='text' class="form-control" required=""/>
                            <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                        </div>
                    </div>
                </div>
                <div class='col-md-2'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker7'>
                            <input name="arrivalTime"  type='text' class="form-control" required=""/>
                            <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker6').datetimepicker();
                    $('#datetimepicker7').datetimepicker({
                        useCurrent: false //Important! See issue #1075
                    });
                    $("#datetimepicker6").on("dp.change", function (e) {
                        $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
                    });
                    $("#datetimepicker7").on("dp.change", function (e) {
                        $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
                    });
                });
            </script>

        </div>


        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="plane">Plane</label>
            <div class="col-md-4">
                <select id="plane" name="plane"  class="form-control">
                        <c:forEach items="${planes}" var="plane">
                           <option value=${plane.id}>${plane.planeName}</option>
                        </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="from">From</label>
            <div class="col-md-4">
                <select id="from" name="from"  class="form-control">
                    <c:forEach items="${airports}" var="airport">
                        <option value=${airport.id}>${airport.acronim}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="to">To</label>
            <div class="col-md-4">
                <select id="to" name="to" role="selectbasicTo" class="form-control">
                    <c:forEach items="${airports}" var="airport">
                        <option value=${airport.id}>${airport.acronim}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="crew">Crew</label>
            <div class="col-md-4">
                <select id="crew" name="crew" role="selectbasicTo" class="form-control">
                    <c:forEach items="${crews}" var="crew">
                        <option value=${crew.id}>${crew.id}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" class="btn btn-success">Create</button>
            </div>
        </div>

    </fieldset>
</form>



<script type="text/javascript" src="jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('#datetimepicker').data("DateTimePicker").FUNCTION()
</script>

<%@ include file="include/end-html.jsp" %>