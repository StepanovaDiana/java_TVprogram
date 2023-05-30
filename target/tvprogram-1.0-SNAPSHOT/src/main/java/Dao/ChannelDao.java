package Dao;

import Entity.Channel;

import java.sql.SQLException;
import java.util.List;

public interface ChannelDao {


    public Channel insert(Channel channel) throws SQLException;

    public Channel getById(long id) throws SQLException;

    public void update(Channel channel) throws SQLException;
    public List<Channel> getAll() throws Exception;
    //public List<Channel> getChannelForProgram(long programId) throws Exception;

    public void delete(long id) throws SQLException;

}
