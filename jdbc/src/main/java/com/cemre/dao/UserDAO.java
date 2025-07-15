package com.cemre.dao;

import com.cemre.User.User;
import java.util.List;

public interface UserDAO {
    void createTable();
    void save(User user);
    List<User>findAll();
    void update(User user);
    void delete(int id);
}
