package by.it.TaskManager.java.dao;

public class Resetdb {
    public static void main(String[] args) {
        Connect.deleteDb();
        Connect.createDb();
    }
}
