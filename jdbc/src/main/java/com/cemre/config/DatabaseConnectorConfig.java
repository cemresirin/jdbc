package com.cemre.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectorConfig {
    private static Connection connection;

    public static void setConnection() {
        try {
             connection = DriverManager.getConnection(
                    DatabaseConfig.DATABASE_URL,
                    DatabaseConfig.DATABASE_USERNAME,
                    DatabaseConfig.DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

     public static void closeConnection() {
          try{
              connection.close();
          }catch(SQLException e)  {
              throw new RuntimeException(e) ;
          }
    }
}
