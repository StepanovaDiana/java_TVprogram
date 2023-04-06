package Dao;

import Entity.UserChannelList;

import java.sql.SQLException;

public interface UserChannelListDao {

    //create
    void create(UserChannelList chList) throws SQLException;


    UserChannelList getById(Long id) throws SQLException;
    //update

    void update(UserChannelList chList) throws SQLException;

    //delete
    void delete(long id) throws SQLException;

}
