package by.it.kruglenja.TaskManager.java.dao;

public class Reset {
    public static void main(String[] args) {
        Connect.deleteDB();
        Connect.createDB();
    }
}
