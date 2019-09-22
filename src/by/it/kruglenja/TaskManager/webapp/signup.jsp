<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>

<body>
<div class="page-header">
    <p>user: <br> ${user}</p>
    <p>sessionUserId: <br> ${sessionUserId}</p>
</div>
<div class="container">

    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Registration form</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userPassword">Password</label>
                <div class="col-md-4">
                    <input id="userPassword" name="userPassword" type="password" placeholder="" class="form-control input-md">
                    <span class="help-block">At least 4 characters, only letters and numbers.</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordValidation">Repaet your password </label>
                <div class="col-md-4">
                    <input id="passwordValidation" name="passwordValidation" type="password" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userEmail">Your email</label>
                <div class="col-md-4">
                    <input id="userEmail" name="userEmail" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singnup"></label>
                <div class="col-md-4">
                    <button id="singnup" name="singnup" class="btn btn-primary">SingnUp</button>
                </div>
            </div>

        </fieldset>
    </form>

    <p><br> ${message}</p>

</div>
</body>
</html>
