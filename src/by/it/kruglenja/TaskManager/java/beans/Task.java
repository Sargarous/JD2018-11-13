package by.it.kruglenja.TaskManager.java.beans;


import java.time.LocalDateTime;

public class Task {

    private long id;
    private String taskName;
    private String taskDescription;
    private LocalDateTime taskStartTime;
    private LocalDateTime taskRedLine;
    private LocalDateTime taskDeadLine;

    private long ProjectList_id;
    private long ProjectList_Users_id;
    private long Project_Users_Roles_id;
    private long Users_id;
    private long Users_Roles_id;

    public Task() {
    }

    public Task(long id, String taskName, String taskDescription, LocalDateTime taskStartTime, LocalDateTime taskRedLine, LocalDateTime taskDeadLine, long projectList_id, long projectList_Users_id, long project_Users_Roles_id, long users_id, long users_Roles_id) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStartTime = taskStartTime;
        this.taskRedLine = taskRedLine;
        this.taskDeadLine = taskDeadLine;
        ProjectList_id = projectList_id;
        ProjectList_Users_id = projectList_Users_id;
        Project_Users_Roles_id = project_Users_Roles_id;
        Users_id = users_id;
        Users_Roles_id = users_Roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getTaskStartTime() {
        return taskStartTime;
    }

    public void settaskStartTime(LocalDateTime taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public LocalDateTime getTaskRedLine() {
        return taskRedLine;
    }

    public void setTaskRedLine(LocalDateTime taskRedLine) {
        this.taskRedLine = taskRedLine;
    }

    public LocalDateTime getTaskDeadLine() {
        return taskDeadLine;
    }

    public void setTaskDeadLine(LocalDateTime taskDeadLine) {
        this.taskDeadLine = taskDeadLine;
    }

    public long getProjectList_id() {
        return ProjectList_id;
    }

    public void setProjectList_id(long projectList_id) {
        ProjectList_id = projectList_id;
    }

    public long getProjectList_Users_id() {
        return ProjectList_Users_id;
    }

    public void setProjectList_Users_id(long projectList_Users_id) {
        ProjectList_Users_id = projectList_Users_id;
    }

    public long getProject_Users_Roles_id() {
        return Project_Users_Roles_id;
    }

    public void setProject_Users_Roles_id(long project_Users_Roles_id) {
        Project_Users_Roles_id = project_Users_Roles_id;
    }

    public long getUsers_id() {
        return Users_id;
    }

    public void setUsers_id(long users_id) {
        Users_id = users_id;
    }

    public long getUsers_Roles_id() {
        return Users_Roles_id;
    }

    public void setUsers_Roles_id(long users_Roles_id) {
        Users_Roles_id = users_Roles_id;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStartTime='" + taskStartTime + '\'' +
                ", taskRedLine='" + taskRedLine + '\'' +
                ", taskDeadLine='" + taskDeadLine + '\'' +
                ", ProjectList_id=" + ProjectList_id +
                ", ProjectList_Users_id=" + ProjectList_Users_id +
                ", Project_Users_Roles_id=" + Project_Users_Roles_id +
                ", Users_id=" + Users_id +
                ", Users_Roles_id=" + Users_Roles_id +
                '}';
    }
}