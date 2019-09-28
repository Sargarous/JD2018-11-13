package by.it.kruglenja.TaskManager.java.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        LocalDateTime newDate = null;
        String dateTime = "2013-03-18 08:30:01";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            newDate = LocalDateTime.parse(dateTime, dtf);
            System.out.println(newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
