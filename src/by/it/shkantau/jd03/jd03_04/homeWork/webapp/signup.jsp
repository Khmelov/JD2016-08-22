<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Sign-up</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputEmail">Login</label>
            <div class="col-md-4">
                <input id="textinputLogin" planeName="textinputLogin" type="text" placeholder="login" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputEmail">Email</label>
            <div class="col-md-4">
                <input id="textinputEmail" planeName="textinputEmail" type="text" placeholder="email" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
                <input id="passwordinput" planeName="passwordinput" type="password" placeholder="password" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinputConfirm">Confirm Password</label>
            <div class="col-md-4">
                <input id="passwordinputConfirm" planeName="passwordinputConfirm" type="password" placeholder="password confirm" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Button Drop Down -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttondropdown">Role</label>
            <div class="col-md-4">
                <div class="input-group">
                    <input id="buttondropdown" planeName="buttondropdown" class="form-control" placeholder="role" type="text" required="">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            Action
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="#">Administrator</a></li>
                            <li><a href="#">Dispatcher</a></li>
                            <li><a href="#">User</a></li>
                        </ul>
                    </div>
                </div>
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


<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>


