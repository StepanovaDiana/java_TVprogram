package DaoImpl;

import Dao.ChannelDao;
import Entity.Channel;
import connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChannelDaoImpl extends ConnectionManager implements ChannelDao {

    Connection connection = getConnection();

    @Override
    public void insert(Channel channel) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO public.CHANNEL ( NAME) VALUES(?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, channel.getName());

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
    public Channel getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME FROM public.CHANNEL WHERE ID=?";
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
        String sql = "UPDATE public.CHANNEL SET NAME=? WHERE ID=?";
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
    public void delete(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM public.CHANNEL WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

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
