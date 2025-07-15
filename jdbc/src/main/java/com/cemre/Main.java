package com.cemre;

import com.cemre.User.User;
import com.cemre.config.DatabaseConnectorConfig;
import com.cemre.dao.UserDAO;
import com.cemre.dao.UserDAOImpl;

import java.sql.*;
import java.util.List;

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

/*
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
*/

/*
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
*/

/*
        //update
         String updateSql = "UPDATE users SET name = ? , email = ? WHERE id = ?";

         try {
             Connection connection =DatabaseConnectorConfig.getConnection();
              PreparedStatement preparedStatement =connection.prepareStatement(updateSql);
              preparedStatement.setString(1, "Ceylin");
              preparedStatement.setString(2, "ceylin@gmail.com");
              preparedStatement.setInt(3,1);
              preparedStatement.executeUpdate();
         }catch(SQLException e){
             throw new RuntimeException(e);
         }
    }
*/
/*
        //delete
        String deleteSql = "DELETE FROM users WHERE id = ?";

        try{
            Connection connection=DatabaseConnectorConfig.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,3);
            preparedStatement.executeUpdate();
        }catch(SQLException e)  {
            throw new RuntimeException(e);
        }
    }
*/

        try{
            DatabaseConnectorConfig.setConnection();
            Connection connection= DatabaseConnectorConfig.getConnection();

            UserDAO userDAO =new UserDAOImpl(connection);
        //  userDAO.createTable()

            //Kullanıcı oluşturma

        //  User user=new User(1,"Cemre",26);
        //  userDAO.save(user);

            //Kullanıcı listeleme
        //  List<User>users =userDAO.findAll();
        //  for(User user :users) {
        //      System.out.println(user.getId() +",İsim:"+user.getName()+",Yaş:"+ user.getAge());


            //Kullanıcı güncelleme

            User updateUser =new User();
        //  updateUser.setId(1);
        //  updateUser.setName("Cemre");
        //  updateUser.setage(30);
        //  userDAO.update(updateUser);


            //Kullanıcı silme
            //  userDAO.delete(2)

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DatabaseConnectorConfig.closeConnection();
        }
    }
}