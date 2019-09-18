<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@include file="include/head.jsp"%>
<div class="container">

    <form class="form-horizontal">
        <fieldset>

            <!-- Form Name -->
            <legend>Authorization</legend>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput"></label>
                <div class="col-md-4">
                    <input id="passwordinput" name="passwordinput" type="password" placeholder="Password" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login"></label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="Login" class="form-control input-md">

                </div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="SignIn"></label>
                <div class="col-md-8">
                    <button id="SignIn" name="SignIn" class="btn btn-success">  SignIn</button>
                    <button id="SignUp" name="SignUp" class="btn btn-warning">SignUp</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>




</html>