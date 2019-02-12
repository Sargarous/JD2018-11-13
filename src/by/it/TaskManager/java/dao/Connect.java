package by.it.TaskManager.java.dao;

import java.sql.*;

public class Connect {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    Connect() throws SQLException {}

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }

    static void deleteDb() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `taskmanagerdb`");
            System.out.println("DB deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     static void createDb(){
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `taskmanagerdb` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanagerdb`.`roles` (" +
                    "  `id` BIGINT(200) NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanagerdb`.`projects` (" +
                    "  `id` BIGINT(200) NOT NULL AUTO_INCREMENT," +
                    "  `projectName` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanagerdb`.`tasks` (" +
                    "  `id` BIGINT(200) NOT NULL AUTO_INCREMENT," +
                    "  `heading` VARCHAR(245) NULL," +
                    "  `description` VARCHAR(2000) NULL," +
                    "  `startTime` TIMESTAMP(1) NULL," +
                    "  `remainTime` TIMESTAMP(1) NULL," +
                    "  `redlineTiime` TIMESTAMP(1) NULL," +
                    "  `deadlineTime` TIMESTAMP(1) NULL," +
                    "  `projects_id` BIGINT(200) NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_tasks_projects1`" +
                    "    FOREIGN KEY (`projects_id`)" +
                    "    REFERENCES `taskmanagerdb`.`projects` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanagerdb`.`users` (" +
                    "  `id` BIGINT(200) NOT NULL AUTO_INCREMENT," +
                    "  `userName` VARCHAR(45) NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `roles_id` BIGINT(200) NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `taskmanagerdb`.`roles` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanagerdb`.`userToProject` (" +
                    "  `id` BIGINT(200) NOT NULL AUTO_INCREMENT," +
                    "  `users_id` BIGINT(200) NOT NULL," +
                    "  `projects_id` BIGINT(200) NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_table1_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `taskmanagerdb`.`users` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION," +
                    "  CONSTRAINT `fk_table1_projects1`" +
                    "    FOREIGN KEY (`projects_id`)" +
                    "    REFERENCES `taskmanagerdb`.`projects` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `taskmanagerdb`.`roles` (`id`, `role`) VALUES (1, 'manager');");
            statement.executeUpdate("INSERT INTO `taskmanagerdb`.`roles` (`id`, `role`) VALUES (2, 'developer');");
            statement.executeUpdate("INSERT INTO `taskmanagerdb`.`roles` (`id`, `role`) VALUES (3, 'guest');");
            System.out.println("DB created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
