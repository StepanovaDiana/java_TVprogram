package Service;

import Dao.ChannelDao;
import Entity.Channel;
import connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChannelService extends ConnectionManager implements ChannelDao {

    Connection connection = getConnection();

    @Override
    public void create(Channel channel) throws SQLException {
        PreparedStatement preparedStatement
                = null;
        String sql = "INSERT INTO CHANNEL (ID, NAME) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, channel.getId());
            preparedStatement.setString(2, channel.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Channel> getAll() throws SQLException {
        List<Channel> channelList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM CHANNEL";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Channel channel = new Channel();
                channel.setId(resultSet.getLong("ID"));
                channel.setName(resultSet.getString("NAME"));
                channelList.add(channel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return channelList;
    }

    @Override
    public Channel getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME FROM CHANNEL WHERE ID=?";
        Channel channel = new Channel();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            channel.setId(resultSet.getLong("ID"));
            channel.setName(resultSet.getString("NAME"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return channel;
    }

    @Override
    public void update(Channel channel) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CHANNEL SET NAME=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, channel.getName());
            preparedStatement.setLong(2, channel.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }

    }

    @Override
    public void delete(Channel channel) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM CHANNEL WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, channel.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }


    }
}
