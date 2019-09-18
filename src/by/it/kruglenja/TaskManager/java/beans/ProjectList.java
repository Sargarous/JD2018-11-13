package by.it.kruglenja.TaskManager.java.beans;

public class ProjectList{
    
    private long id;
    private String projectName;
    private String projectDescription;
    private String projectStart;
    private String projectRedLine;
    private String projectDeadLine;

    private long Users_id;
    private long Users_Roles_id;

    public ProjectList() {
    }

    public ProjectList(long id, String projectName, String projectDescription, String projectStart, String projectRedLine, String projectDeadLine, long users_id, long users_Roles_id) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStart = projectStart;
        this.projectRedLine = projectRedLine;
        this.projectDeadLine = projectDeadLine;
        this.Users_id = users_id;
        this.Users_Roles_id = users_Roles_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getprojectDescription() {
        return projectDescription;
    }

    public void setprojectDescription(String projectDescription) {
        projectDescription = projectDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(String projectStart) {
        this.projectStart = projectStart;
    }

    public String getProjectRedLine() {
        return projectRedLine;
    }

    public void setProjectRedLine(String projectRedLine) {
        this.projectRedLine = projectRedLine;
    }

    public String getProjectDeadLine() {
        return projectDeadLine;
    }

    public void setProjectDeadLine(String projectDeadLine) {
        this.projectDeadLine = projectDeadLine;
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
        return "ProjectList{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectStart='" + projectStart + '\'' +
                ", projectRedLine='" + projectRedLine + '\'' +
                ", projectDeadLine='" + projectDeadLine + '\'' +
                ", Users_id=" + Users_id +
                ", Users_Roles_id=" + Users_Roles_id +
                '}';
    }
}