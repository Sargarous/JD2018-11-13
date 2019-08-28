package by.it.kruglenja.Project.java.dao;

import by.it.kruglenja.Project.java.beans.Roles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

class Connect {
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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `TaskManager` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createDb() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `TaskManager` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskManager`.`Roles` (" +
                    "  `RoleId` INT NOT NULL," +
                    "  `roleName` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`RoleId`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskManager`.`Users` (" +
                    "  `UserId` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                    "  `userName` VARCHAR(45) NULL," +
                    "  `userPassword` VARCHAR(45) NULL," +
                    "  `userEmail` VARCHAR(45) NULL," +
                    "  `Roles_idRoles` INT NOT NULL," +
                    "  PRIMARY KEY (`UserId`, `Roles_RoleId`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskManager`.`Priority` (" +
                    "  `PriorityId` INT NOT NULL AUTO_INCREMENT," +
                    "  `priorityName` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`PriorityId`))" +
                    "ENGINE = InnoDB;");
            
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskManager`.`ProjectList` (" +
                    "  `ProjectId` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                    "  `ProjectListcol` VARCHAR(45) NULL," +
                    "  `Users_UserId` INT NOT NULL," +
                    "  `Users_Roles_idRoles` INT NOT NULL," +
                    "  `Priority_idPriority` INT NOT NULL," +
                    "  `ProjectSrart` TIMESTAMP NOT NULL," +
                    "  `ProjectRedLine` TIMESTAMP NOT NULL," +
                    "  `ProjectDeadLine` TIMESTAMP NOT NULL," +
                    "  `ProjectTimeLeft` TIMESTAMP NOT NULL," +
                    "  PRIMARY KEY (`ProjectId`, `Users_UserId`, `Users_Roles_idRoles`, `Priority_idPriority`))" +
                    "ENGINE = InnoDB;");
            
            statement.executeUpdate("INSERT INTO `TaskManager`.`Roles` (`RoleId`, `roleName`) VALUES (1, 'user');");
            statement.executeUpdate("INSERT INTO `TaskManager`.`Roles` (`RoleId`, `roleName`) VALUES (2, 'guest');");
            statement.executeUpdate("INSERT INTO `TaskManager`.`Roles` (`RoleId`, `roleName`) VALUES (3, 'admin');");

            statement.executeUpdate("INSERT INTO `TaskManager`.`Priority` (`PriorityId`, `priorityName`) VALUES (1, 'hi');");
            statement.executeUpdate("INSERT INTO `TaskManager`.`Priority` (`PriorityId`, `priorityName`) VALUES (2, 'medium');");
            statement.executeUpdate("INSERT INTO `TaskManager`.`Priority` (`PriorityId`, `priorityName`) VALUES (3, 'low');");

            System.out.println("DB created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
