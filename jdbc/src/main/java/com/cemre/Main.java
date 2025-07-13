package com.cemre;

import com.cemre.config.DatabaseConnectorConfig;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

/*

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
 */


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

        String selectsql = " SELECT * FROM users";

        try {
            Connection connection = DatabaseConnectorConfig.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(selectsql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));

            }

            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }