package Dao;

import Entity.Channel;

import java.sql.SQLException;
import java.util.List;

public interface ChannelDao {


    //create
    void create(Channel channel) throws SQLException;

    //read
    List<Channel> getAll() throws SQLException;

    Channel getById(Long id) throws SQLException;
    //update

    void update(Channel channel) throws SQLException;

    //delete
    void delete(Channel channel) throws SQLException;

}
