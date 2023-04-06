package Dao;

import Entity.User;

import java.sql.SQLException;

public interface UserDao {

    //create
    void create(User user) throws SQLException;


    User getById(Long id) throws SQLException;
    //update

    void update(User user) throws SQLException;

    //delete
    void delete(long id) throws SQLException;

}




