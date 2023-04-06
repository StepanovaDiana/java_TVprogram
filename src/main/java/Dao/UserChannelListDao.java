package Dao;

import Entity.UserChannelList;

import java.sql.SQLException;
import java.util.List;

public interface UserChannelListDao {

    //create
    void create(UserChannelList chList) throws SQLException;

    //read
    List<UserChannelList> getAll() throws SQLException;

    UserChannelList getById(Long id) throws SQLException;
    //update

    void update(UserChannelList chList) throws SQLException;

    //delete
    void delete(UserChannelList chList) throws SQLException;

}
