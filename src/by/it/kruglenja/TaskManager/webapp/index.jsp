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

    <form class="form-horizontal" action="do?command=Index" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Login</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" value="123" name="login" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>
            <!-- userPassword input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userPassword">Password</label>
                <div class="col-md-4">
                    <input id="userPassword" value="12345" name="userPassword" type="userPassword" placeholder=""
                           class="form-control input-md">

                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="SignIn"></label>
                <div class="col-md-4">
                    <button id="SignIn" name="SignIn" class="btn btn-success">SignIn</button>
                </div>
            </div>
            <a class="btn btn-success" href="do?command=SignUp">SignUp</a>
<%--            --%>
        </fieldset>
    </form>


    <p><br> ${message}</p>

</div>
</body>
</html>
