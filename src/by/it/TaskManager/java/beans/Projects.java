package by.it.TaskManager.java.beans;

public class Projects {
    private long id;
    private String prrojectsName;

    public Projects() {
    }

    public Projects(long id, String prrojectsName) {
        this.id = id;
        this.prrojectsName = prrojectsName;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPrrojectsName() { return prrojectsName; }

    public void setPrrojectsName(String prrojectsName) { this.prrojectsName = prrojectsName; }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", prrojectsName='" + prrojectsName + '\'' +
                '}';
    }
}
