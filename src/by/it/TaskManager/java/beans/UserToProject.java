package by.it.TaskManager.java.beans;

public class UserToProject {
private long id;
private long users_id;
private long projects_id;

    public UserToProject() {
    }

    public UserToProject(long id, long users_id, long projects_id) {
        this.id = id;
        this.users_id = users_id;
        this.projects_id = projects_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    public long getProjects_id() { return projects_id; }

    public void setProjects_id(long projects_id) { this.projects_id = projects_id; }

    @Override
    public String toString() {
        return "UserToProject{" +
                "id=" + id +
                ", users_id=" + users_id +
                ", projects_id=" + projects_id +
                '}';
    }
}


