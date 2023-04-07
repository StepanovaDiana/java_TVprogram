package Dao;

import Entity.Channel;

import java.sql.SQLException;

public interface ChannelDao {


    public void insert(Channel channel) throws SQLException;

    public Channel getById(long id) throws SQLException;

    public void update(Channel channel) throws SQLException;

    public void delete(long id) throws SQLException;

}
