package by.it.kruglenja.TaskManager.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Connect {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;


    static Connection getConnection() throws SQLException {
        synchronized (Connect.class) {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
            }
        }
        return connection;
    }


    static void createDB() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", CN.USER, CN.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `taskmanager`;");
            System.out.println("TaskManDB Erased");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `taskmanager` DEFAULT CHARACTER SET utf8 ;");
            System.out.println("TaskManDB UP");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanager`.`Roles` (" +
                    "  `id` BIGINT NOT NULL," +
                    "  `roleName` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB");
            System.out.println("RolesTable UP");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanager`.`User` (" +
                    "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL," +
                    "  `userPassword` VARCHAR(45) NULL," +
                    "  `userEmail` VARCHAR(45) NULL," +
                    "  `Roles_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`, `Roles_id`))" +
                    "ENGINE = InnoDB;");
            System.out.println("UserTable UP");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanager`.`ProjectList` (" +
                    "  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT," +
                    "  `projectName` VARCHAR(195) NULL," +
                    "  `projectDescription` VARCHAR(195) NULL," +
                    "  `projectSrart` VARCHAR(195) NULL," +
                    "  `projectRedLine` VARCHAR(195) NULL," +
                    "  `projectDeadLine` VARCHAR(195) NULL," +
                    "  `Users_id` BIGINT UNSIGNED NOT NULL," +
                    "  `Users_Roles_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`, `Users_id`, `Users_Roles_id`))" +
                    "ENGINE = InnoDB;");
            System.out.println("ProjectListTable UP");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `taskmanager`.`Tasks` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `taskName` VARCHAR(195) NULL," +
                    "  `taskDescription` VARCHAR(255) NULL," +
                    "  `taskStartTime` VARCHAR(195) NULL," +
                    "  `taskRedLine` VARCHAR(195) NULL," +
                    "  `taskDeadLine` VARCHAR(195) NULL," +
                    "  `ProjectList_id` BIGINT UNSIGNED NOT NULL," +
                    "  `ProjectList_Users_id` BIGINT UNSIGNED NOT NULL," +
                    "  `ProjectList_Users_Roles_id` BIGINT NOT NULL," +
                    "  `Users_id` BIGINT UNSIGNED NOT NULL," +
                    "  `Users_Roles_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`, `ProjectList_id`, `ProjectList_Users_id`, `ProjectList_Users_Roles_id`, `Users_id`, `Users_Roles_id`))" +
                    "ENGINE = InnoDB;");
            System.out.println("TasksTable UP");
            statement.executeUpdate("INSERT INTO `taskmanager`.`Roles` (`id`, `roleName`) VALUES (1, 'user');");
            statement.executeUpdate("INSERT INTO `taskmanager`.`Roles` (`id`, `roleName`) VALUES (2, 'guest');");
            statement.executeUpdate("INSERT INTO `taskmanager`.`Roles` (`id`, `roleName`) VALUES (3, 'admin');");
            System.out.println("Roles Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

