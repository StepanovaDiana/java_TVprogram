package DaoImpl;

import Dao.ChannelDao;
import Entity.Channel;
import connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChannelDaoImpl extends ConnectionManager implements ChannelDao {

    private final ConnectionManager builder = new ConnectionManager();

    public Connection getConnection() {
        return builder.getConnection();
    }

    @Override
    public void insert(Channel channel) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO public.CHANNEL ( NAME) VALUES(?)";

        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, channel.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    @Override
    public Channel getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME FROM public.CHANNEL WHERE ID=?";
        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Channel channel = new Channel();
                channel.setId(resultSet.getLong("ID"));
                channel.setName(resultSet.getString("NAME"));
                return channel;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }
    @Override
    public List<Channel> getAll() {
        try (Connection connection = getConnection()) {
            String sql = "SELECT ID,NAME FROM public.CHANNEL";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Channel> res = new ArrayList<>();
            while (resultSet.next()) {
                Channel channel = new Channel();
                channel.setId(resultSet.getLong("id"));
                channel.setName(resultSet.getString("name"));
                res.add(channel);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Channel channel) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE public.CHANNEL SET NAME=? WHERE ID=?";
        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, channel.getName());
            preparedStatement.setLong(2, channel.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }


    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM public.CHANNEL WHERE ID=?";
        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }


    }
}
