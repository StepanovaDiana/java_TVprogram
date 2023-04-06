package Service;

import Dao.UserChannelListDao;
import Entity.UserChannelList;
import connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserChannelListService extends ConnectionManager implements UserChannelListDao {
    Connection connection = getConnection();

    @Override
    public void create(UserChannelList chList) throws SQLException {
        PreparedStatement preparedStatement
                = null;
        String sql = "INSERT INTO USER_CHANNEL_LIST ( IS_FAVORITE,ID_USER_FK,ID_CHANNEL_FK) VALUES(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, chList.isFavorite());
            preparedStatement.setLong(2, chList.getIdUserFk());
            preparedStatement.setLong(3, chList.getIdChannelFk());

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
    public List<UserChannelList> getAll() throws SQLException {
        List<UserChannelList> chList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM CHANNEL";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UserChannelList userChannelList = new UserChannelList();
                userChannelList.setId(resultSet.getLong("ID"));
                userChannelList.setFavorite(resultSet.getBoolean("IS_FAVORITE"));
                userChannelList.setIdChannelFk(resultSet.getLong("ID_CHANNEL_FK"));
                userChannelList.setIdUserFk(resultSet.getLong("ID_USER_FK"));
                chList.add(userChannelList);
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
        return chList;
    }

    @Override
    public UserChannelList getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,IS_FAVORITE,ID_USER_FK,ID_CHANNEL_FK FROM USER_CHANNEL_LIST WHERE ID=?";
        UserChannelList userChannelList = new UserChannelList();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            userChannelList.setId(resultSet.getLong("ID"));
            userChannelList.setFavorite(resultSet.getBoolean("IS_FAVORITE"));
            userChannelList.setIdChannelFk(resultSet.getLong("ID_CHANNEL_FK"));
            userChannelList.setIdUserFk(resultSet.getLong("ID_USER_FK"));

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
        return userChannelList;
    }

    @Override
    public void update(UserChannelList chList) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE USER_CHANNEL_LIST SET IS_FAVORITE=?,ID_CHANNEL_FK=?,ID_USER_FK=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, chList.isFavorite());
            preparedStatement.setLong(2, chList.getIdUserFk());
            preparedStatement.setLong(3, chList.getIdChannelFk());
            preparedStatement.setLong(4, chList.getId());

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
    public void delete(UserChannelList chList) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM USER_CHANNEL_LIST WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, chList.getId());

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
