package crud;

import DaoImpl.ChannelDaoImpl;
import Entity.Channel;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ChannelTest {
    public final ChannelDaoImpl channelDao=new ChannelDaoImpl();
    public final Channel c=new Channel();

    @Test
    public void insertChannelTest()throws  Exception{
        initChannel();
        //channelDao.getById(c.getId()).getName();
        assertEquals(c.getId(),channelDao.getById(c.getId()).getId());
    }
    @Test
    public void deleteChannelTest()throws  Exception{
        initChannel();
        channelDao.delete(c.getId());
        assertNull(channelDao.getById(c.getId()));
    }
    @Test
    public void updateChannelTest() throws SQLException {
        initChannel();
        c.setName("стс");
        channelDao.update(c);
        assertEquals(c.getName(), channelDao.getById(c.getId()).getName());

    }
    @Test
    public void getAllChannelTest() {
        List<Channel> c = channelDao.getAll();
        assertEquals(c.size(),channelDao.getAll().size());
    }

    @Test
    public void getByChannelTest() throws SQLException {
        initChannel();
        assertEquals(c.getId(),channelDao.getById(c.getId()).getId() );
    }

    void initChannel() throws SQLException{
        c.setName("музтв");
        c.setId(1);
        Channel channel=channelDao.insert(c);
        //c.setId(channel.getId());
        channelDao.insert(channel);

    }
}
