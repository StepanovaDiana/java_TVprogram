package Dao;

import Entity.Channel;

import java.sql.SQLException;

public interface ChannelDao {


    //create
    void create(Channel channel) throws SQLException;


    Channel getById(Long id) throws SQLException;
    //update

    void update(Channel channel) throws SQLException;

    //delete
    void delete(long id) throws SQLException;

}
