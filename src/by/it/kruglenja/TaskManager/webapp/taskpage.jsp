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
        $('#taskStartTime').datetimepicker({useCurrent: true, format: 'YYYY-MM-DD HH:mm'});
        $('#taskRedLine').datetimepicker({useCurrent: false, format: 'YYYY-MM-DD HH:mm'});
        $('#taskDeadLine').datetimepicker({useCurrent: false, format: 'YYYY-MM-DD HH:mm'});
    });
</script>
<body>


<div class="container">
    <div class="page-header">
        <p>user: ${user}</p>
    </div>
    <h1>Tasks</h1>

    <table id="taskTable" class="table table-bordered">
        <thead>
        <tr>
            <th scope="col" style="display:none;">id</th>
            <th scope="col">taskName</th>
            <th scope="col">taskDescription</th>
            <th scope="col">taskStartTimer</th>
            <th scope="col">taskRedLine</th>
            <th scope="col">taskDeadLine</th>
            <th scope="col">taskRedLineTimer</th>
            <th scope="col">taskDeadLineTimer</th>
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
                    <td>${task.taskRedLine}</td>
                    <td>${task.taskDeadLine}</td>
                    <td></td>
                    <td></td>

                    <td>
                        <button id="delete" value="delete" name="delete" class="btn btn-danger">Удалить</button>
                    </td>
                </tr>
            </form>
        </c:forEach>

        </tbody>

    </table>
    <script>
        var table = document.getElementById("taskTable");

        var x = setInterval(
            function () {

                for (var i = 1, row; row = table.rows[i]; i++) {
                    //iterate through rows
                    //rows would be accessed using the "row" variable assigned in the for loop

                    var endDate = row.cells[4];
                    var countDownDate = new Date(endDate.innerHTML.replace(/-/g, "/")).getTime();
                    var countDown = row.cells[6];
                    // Update the count down every 1 second

                    // Get todays date and time
                    var now = new Date().getTime();

                    // Find the distance between now an the count down date
                    var distance = countDownDate - now;

                    // Time calculations for days, hours, minutes and seconds
                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);


                    // Display the result in the element
                    countDown.innerHTML = (days + "d " + hours + "h "
                        + minutes + "m " + seconds + "s ");

                    //If the count down is finished, write some text
                    if (distance < 0) {
                        clearInterval(x);
                        countDown.innerHTML = "EXPIRED";
                    }
                }
            }, 1000);

    </script>
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
                        <input type='text' class="form-control" name="taskStartTime"/>
                        <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4">Red line day and time</label>
                    <div class='input-group date col-md-4' id='taskRedLine'>
                        <input type='text' class="form-control" name="taskRedLine"/>
                        <span class="input-group-addon">
                     <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4">Dead line day and time</label>
                    <div class='input-group date col-md-4' id='taskDeadLine'>
                        <input type='text' class="form-control" name="taskDeadLine"/>
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
</div>
</body>
</html>