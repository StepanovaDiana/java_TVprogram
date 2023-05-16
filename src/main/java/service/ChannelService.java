package service;

import DaoImpl.ChannelDaoImpl;
import Entity.Channel;

import java.sql.SQLException;
import java.util.List;

public class ChannelService {
    private final ChannelDaoImpl channelDaoimpl;

    public ChannelService() {
        this.channelDaoimpl = new ChannelDaoImpl();

    }
    public void insert(Channel channel){
        try{
             channelDaoimpl.insert(channel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Channel getById(long id){
        try{
            return channelDaoimpl.getById(id);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Channel> getAll(){
        try{
            return channelDaoimpl.getAll();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Channel channel){
        try{
             channelDaoimpl.update(channel);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(long id){
        try{
             channelDaoimpl.delete(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
