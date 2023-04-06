package Service;

import Dao.UserDao;
import Entity.User;
import connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDao {

  //  Connection connection = getConnection();

    @Override
    public void create(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO public.\"user\" ( name,e_mail,password)  VALUES(?,?,?)";

        try (Connection connection=ConnectionManager.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID,NAME,E_MAIL,PASSWORD FROM public.\"user\"";
        Statement statement = null;
        try (Connection connection=ConnectionManager.getConnection()){
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setEmail(resultSet.getString("E_MAIL"));
                user.setPassword(resultSet.getString("PASSWORD"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME,E_MAIL,PASSWORD FROM public.\"user\" WHERE ID=?";
        User user = new User();
        try (Connection connection=ConnectionManager.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            user.setId(resultSet.getLong("ID"));
            user.setName(resultSet.getString("NAME"));
            user.setEmail(resultSet.getString("E_MAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE public.\"user\" SET NAME=?,E_MAIL=?,PASSWORD=? WHERE ID=?";
        try(Connection connection=ConnectionManager.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM public.\"user\" WHERE ID=?";
        try (Connection connection=ConnectionManager.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
