<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript">
    $(function () {
        $('#taskStartTime').datetimepicker({useCurrent: true });
        $('#taskRedLine').datetimepicker({useCurrent: false});
        $('#taskDeadLine').datetimepicker({useCurrent: false});
    });
</script>


<body>
<div class="page-header">
    <p>user: ${user}</p>
    <p>task: ${task}</p>
</div>
<h1>Tasks</h1>
</div>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">taskName</th>
        <th scope="col">taskDescription</th>
        <th scope="col">taskStartTime</th>
        <th scope="col">taskRedLine</th>
        <th scope="col">taskDeadLine</th>

    </tr>
    </thead>

    <tbody>

    <c:forEach items="${tasksList}" var="task">
        <form class="update-user" action="do?command=EditTask" method=post>
            <tr>
                <td>${task.id}</td>
                <td>${task.taskName}</td>
                <td>${task.taskDescription}</td>
                <td>${task.taskStartTime}</td>
<%--                <td>${task.taskRedLine}</td>--%>
<%--                <td>${task.taskDeadLine}</td>--%>
<%--                <td>--%>
<%--                    <button id="delete" value="delete" name="delete" class="btn btn-danger">Удалить</button>--%>
<%--                </td>--%>
            </tr>
        </form>
    </c:forEach>
    </tbody>

</table>





<div class="container">
    <form class="form-horizontal" action="do?command=TaskCreate" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Create new task'</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="taskName">Task</label>
                <div class="col-md-4">
                    <input id="taskName" name="taskName" type="text" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="taskDescription">Description</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="taskDescription" name="taskDescription"></textarea>
                </div>
            </div>

            <%-- Date picking form--%>
            <div class="form-group">
                <label class="control-label col-md-4">Start time</label>
                <div class='input-group date col-md-4' id='taskStartTime'>
                    <input type='text' class="form-control"/>
                    <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Red line day and time</label>
                <div class='input-group date col-md-4' id='taskRedLine'>
                    <input type='text' class="form-control"/>
                    <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Dead line day and time</label>
                <div class='input-group date col-md-4' id='taskDeadLine'>
                    <input type='text' class="form-control"/>
                    <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                </div>
            </div>
            
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createTask"></label>
                <div class="col-md-4">
                    <button id="createTask" name="createTask" class="btn btn-success">Create</button>
                </div>
            </div>
        </fieldset>
    </form>


    <p><br> ${message}</p>

</div>

</div>
</body>
</html>