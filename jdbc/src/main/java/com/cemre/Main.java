package com.cemre;

import com.cemre.config.DatabaseConnectorConfig;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS users("+
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100), " +
                "email VARCHAR(100) " +
                ")";

        try{
            Connection connection = DatabaseConnectorConfig.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sql);
            System.out.println("Table created");

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

