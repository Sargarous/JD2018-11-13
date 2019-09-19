<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>

<body>
<div class="page-header">
    <p>sesionUserId: <br> ${sesionUserId}</p>
</div>
<div class="container">
    <table class="table table-bordered">

        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Login</th>
            <th scope="col">Password</th>
            <th scope="col">userEmail</th>

        </tr>
        </thead>
        <c:forEach items="${users}" var="user">

            <tbody>

            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.userPassword}</td>
                <td>${user.userEmail}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>


    <%--    <form class="form-horizontal" action="do?command=Login" method="post">--%>
    <%--        <fieldset>--%>

    <%--            <!-- Form Name -->--%>
    <%--            <legend>Authorization</legend>--%>

    <%--            <!-- Text input-->--%>
    <%--            <div class="form-group">--%>
    <%--                <label class="col-md-4 control-label" for="login"></label>--%>
    <%--                <div class="col-md-4">--%>
    <%--                    <input id="login" value="123" name="login" type="text" placeholder="Login" class="form-control input-md">--%>

    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <!-- Password input-->--%>
    <%--            <div class="form-group">--%>
    <%--                <label class="col-md-4 control-label" for="password"></label>--%>
    <%--                <div class="col-md-4">--%>
    <%--                    <input id="password" value="123" name="password" type="password" placeholder="Password"--%>
    <%--                    class="form-control input-md">--%>

    <%--                </div>--%>
    <%--            </div>--%>


    <%--            <!-- Button (Double) -->--%>
    <%--            <div class="form-group">--%>
    <%--                <label class="col-md-4 control-label" for="SignIn"></label>--%>
    <%--                <div class="col-md-8">--%>
    <%--                    <button id="SignIn" name="SignIn" class="btn btn-success">SignIn</button>--%>
    <%--                    <button id="SignUp" name="SignUp" class="btn btn-warning">SignUp</button>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </fieldset>--%>
    <%--        <p><br> ${message}</p>--%>
    <%--    </form>--%>

</div>
</body>
</html>
