package by.it.TaskManager.java.beans;

public class Users {
    private long id;
    private String userName;
    private String password;
    private long roles_id;

    public Users() {
    }

    public Users(long id, String userName, String password, long roles_id) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles_id = roles_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public long getRoles_id() { return roles_id; }

    public void setRoles_id(long roles_id) { this.roles_id = roles_id; }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}

