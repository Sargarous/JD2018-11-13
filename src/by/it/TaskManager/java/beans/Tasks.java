package by.it.TaskManager.java.beans;

import com.sun.jmx.snmp.Timestamp;

public class Tasks {
    private long id;
    private String heading;
    private String description;
    private Timestamp startTime;
    private Timestamp remainTime;
    private Timestamp redlineTime;
    private Timestamp deadlineTime;
    private long projects_id;

    public Tasks() {
    }

    public Tasks(long id, String heading, String description, Timestamp startTime, Timestamp remainTime, Timestamp redlineTime, Timestamp deadlineTime, long projects_id) {
        this.id = id;
        this.heading = heading;
        this.description = description;
        this.startTime = startTime;
        this.remainTime = remainTime;
        this.redlineTime = redlineTime;
        this.deadlineTime = deadlineTime;
        this.projects_id = projects_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getHeading() { return heading; }

    public void setHeading(String heading) { this.heading = heading; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Timestamp getStartTime() { return startTime; }

    public void setStartTime(Timestamp startTime) { this.startTime = startTime; }

    public Timestamp getRemainTime() { return remainTime; }

    public void setRemainTime(Timestamp remainTime) { this.remainTime = remainTime; }

    public Timestamp getRedlineTime() { return redlineTime; }

    public void setRedlineTime(Timestamp redlineTime) { this.redlineTime = redlineTime; }

    public Timestamp getDeadlineTime() { return deadlineTime; }

    public void setDeadlineTime(Timestamp deadlineTime) { this.deadlineTime = deadlineTime; }

    public long getProjects_id() { return projects_id; }

    public void setProjects_id(long projects_id) { this.projects_id = projects_id; }

    @Override
    public String toString() {
        return "tasks{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", remainTime=" + remainTime +
                ", redlineTime=" + redlineTime +
                ", deadlineTime=" + deadlineTime +
                ", projects_id=" + projects_id +
                '}';
    }
}



