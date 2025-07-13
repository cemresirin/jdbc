package com.cemre;

import com.cemre.config.DatabaseConnectorConfig;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS users(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100), " +
                "email VARCHAR(100) " +
                ")";

        try {
            Connection connection = DatabaseConnectorConfig.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sql);
            System.out.println("Table created");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String insertSql = "INSERT INTO users (name,email) VALUES(?,?)";

        try (Connection connection = DatabaseConnectorConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, "Cemre");
            preparedStatement.setString(2, "cemre25355@gmail.com");
            preparedStatement.executeUpdate();
            System.out.println("Kayıt eklendi");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}