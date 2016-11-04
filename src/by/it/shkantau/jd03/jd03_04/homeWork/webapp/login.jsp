<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Login</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Login</label>
            <div class="col-md-4">
                <input id="textinput" planeName="textinput" type="text" placeholder="login" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
                <input id="passwordinput" planeName="passwordinput" type="password" placeholder="password" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button1id"></label>
            <div class="col-md-8">
                <button id="button1id" planeName="button1id" class="btn btn-success">Ok</button>
                <button id="button2id" planeName="button2id" class="btn btn-danger">Cancel</button>
            </div>
        </div>

    </fieldset>
</form>


<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>