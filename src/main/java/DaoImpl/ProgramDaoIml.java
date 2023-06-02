package DaoImpl;

import Dao.ProgramDao;
import Entity.Program;
import connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramDaoIml extends ConnectionManager implements ProgramDao {

    private final ConnectionManager builder = new ConnectionManager();

    public Connection getConnection() {
        return builder.getConnection();
    }

    @Override
    public Program insert(Program program) throws SQLException {
        PreparedStatement preparedStatement
                = null;
        String sql = "INSERT INTO public.Program ( NAME, ID_CHANNEL_FK, DURATION, DATETIME)" + "VALUES(?,?,?,?)";

        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql,  new String[]{"id"});
            preparedStatement.setString(1, program.getName());
            preparedStatement.setLong(2, program.getIdChannelFk());
            preparedStatement.setInt(3, program.getDuration());
            preparedStatement.setDate(4, program.getDatetime());
            preparedStatement.executeUpdate();
            var generetedKey = preparedStatement.getGeneratedKeys();
            generetedKey.next();
            program.setId(generetedKey.getLong("id"));
            return program;



        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public List<Program> getAll() {
        List<Program> programs = new ArrayList<>();
        String sql = "SELECT ID,NAME,DURATION,DATETIME,ID_CHANNEL_FK FROM public.PROGRAM";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Program p = new Program();
                p.setId(resultSet.getLong("ID"));
                p.setName(resultSet.getString("NAME"));
                p.setIdChannelFk(resultSet.getLong("ID_CHANNEL_FK"));
                p.setDatetime(resultSet.getDate("DATETIME"));
                p.setDuration(resultSet.getInt("DURATION"));
                programs.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return programs;
    }


    @Override
    public Program getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME,DURATION,DATETIME,ID_CHANNEL_FK FROM public.PROGRAM WHERE ID=? ";

        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Program program = new Program();
                program.setId(resultSet.getLong("ID"));
                program.setName(resultSet.getString("NAME"));
                program.setIdChannelFk(resultSet.getLong("ID_CHANNEL_FK"));
                program.setDatetime(resultSet.getDate("DATETIME"));
                program.setDuration(resultSet.getInt("DURATION"));
                return program;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Program> getAllForChannel(long channelId) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT p.ID,p.NAME,p.DURATION,p.DATETIME, p.id_channel_fk FROM public.PROGRAM p where p.id_channel_fk=? order by p.DATETIME";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, channelId);
            ResultSet resultSet = statement.executeQuery();

            List<Program> res = new ArrayList<>();
            while (resultSet.next()) {
                Program program = new Program();
                program.setId(resultSet.getLong("id"));
                program.setName(resultSet.getString("name"));
                program.setDuration(resultSet.getInt("duration"));
                program.setDatetime(resultSet.getDate("datetime"));
                program.setIdChannelFk(resultSet.getLong("id_channel_fk"));
                res.add(program);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Program program) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE public.PROGRAM SET NAME=?,DURATION=?,DATETIME=?,ID_CHANNEL_FK=?" + " WHERE ID=?";
        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, program.getName());
            preparedStatement.setInt(2, program.getDuration());
            preparedStatement.setDate(3, program.getDatetime());
            preparedStatement.setLong(4, program.getIdChannelFk());
            preparedStatement.setLong(5, program.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM public.PROGRAM WHERE ID=?";

        try (Connection connection = getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
