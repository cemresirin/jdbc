package com.cemre.dao;

import com.cemre.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS userss (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "age INT )";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO userss(name,age) VALUES(?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
            System.out.println("Kayıt eklendi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM userss";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


    @Override
    public void update(User user) {
        String sql = "UPDATE userss SET name=? , age=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.executeUpdate();
            System.out.println("Kullanıcı güncellendi");

        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı güncellenemedi", e);
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM userss WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();
            System.out.println("Kullanıcı silindi");

        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı silinmedi", e);
        }
    }
}
