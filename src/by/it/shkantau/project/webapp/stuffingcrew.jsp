
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="airport?command=StuffingCrew" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend align="center">Stuffing the crew</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pilot1">Pilot1</label>
            <div class="col-md-4">
                <select id="pilot1" name="pilot1"  class="form-control">
                    <option value="" selected disabled>pilot1</option>
                    <c:forEach items="${pilots}" var="pilot">
                        <option value=${pilot.id}>${pilot.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="pilot2">Pilot2</label>
            <div class="col-md-4">
                <select id="pilot2" name="pilot2"  class="form-control">
                    <option value="" selected disabled>pilot2</option>
                    <c:forEach items="${pilots}" var="pilot">
                        <option value=${pilot.id}>${pilot.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="airhostess1">Airhostess1</label>
            <div class="col-md-4">
                <select id="airhostess1" name="airhostess1"   class="form-control">
                    <option value="" selected disabled>airhostess1</option>
                    <c:forEach items="${airhostesses}" var="airhostess">
                        <option value=${airhostess.id}>${airhostess.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="airhostess2">Airhostess2</label>
            <div class="col-md-4">
                <select id="airhostess2" name="airhostess2"  class="form-control">
                    <option value="" selected disabled>airhostess2</option>
                    <c:forEach items="${airhostesses}" var="airhostess">
                        <option value=${airhostess.id}>${airhostess.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton"  class="btn btn-success">Create Crew</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
