package Dao;

import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //create
    void create(User user) throws SQLException;

    //read
    List<User> getAll() throws SQLException;

    User getById(Long id) throws SQLException;
    //update

    void update(User user) throws SQLException;

    //delete
    void delete(User user) throws SQLException;

}




