package by.it.kruglenja.TaskManager.java.dao;

import by.it.kruglenja.TaskManager.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDAO<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `user`( `login`, `userPassword`, `userEmail`, `Roles_id`) VALUES ('%s', '%s', '%s', '%d')",
                user.getlogin(), user.getUserPassword(), user.getUserEmail(), user.getRoles_id());
        long id = Dao.executeCreate(sql);
        user.setId(id);
        return id > 0;
    }

    public User read(long id) throws SQLException {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `user` SET `login` = '%s', `userPassword`= '%s',`userEmail` = '%s'," +
                        "`Roles_id` = '%d' WHERE `user`.`id` = '%d'", user.getlogin(), user.getUserPassword(),
                user.getUserEmail(), user.getRoles_id(), user.getId());
        return Dao.executeUpdate(sql);
    }

    public boolean delete(long id) throws SQLException {
        String sql = String.format("DELETE FROM `user` WHERE `user`.`id` = %d", id);
        return Dao.executeUpdate(sql);
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = String.format("SELECT `id`, `login`, `userPassword`, `userEmail`, `Roles_id` FROM `user` %s", sqlSuffix);

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                User user = new User();
                user.setId(res.getLong("id"));
                user.setlogin(res.getString("login"));
                user.setUserPassword(res.getString("userPassword"));
                user.setUserEmail(res.getString("userEmail"));
                user.setRoles_id(res.getLong("Roles_id"));
                users.add(user);
            }
        }
        return users;
    }
}
