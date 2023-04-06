package Service;

import Dao.ProgramDao;
import Entity.Program;
import connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramService extends ConnectionManager implements ProgramDao {
    Connection connection = getConnection();

    @Override
    public void create(Program program) throws SQLException {
        PreparedStatement preparedStatement
                = null;
        String sql = "INSERT INTO Program ( NAME, ID_CHANNEL_FK, DURATION, DATETIME)" + "VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, program.getName());
            preparedStatement.setLong(2, program.getIdChannelFk());
            preparedStatement.setInt(3, program.getDuration());
            preparedStatement.setDate(4, program.getDatetime());

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
    public List<Program> getAll() throws SQLException {
        List<Program> programList = new ArrayList<>();
        String sql = "SELECT ID,NAME, ID_CHANNEL_FK, DURATION, DATETIME FROM PUBLIC.PROGRAM";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Program program = new Program();
                program.setId(resultSet.getLong("ID"));
                program.setName(resultSet.getString("NAME"));
                program.setIdChannelFk(resultSet.getLong("ID_CHAHHEL_FK"));
                program.setDatetime(resultSet.getDate("DATETIME"));
                program.setDuration(resultSet.getInt("DURATION"));


                programList.add(program);
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
        return programList;
    }

    @Override
    public Program getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME  FROM CHANNEL WHERE ID=? ";
        Program program = new Program();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            program.setId(resultSet.getLong("ID"));
            program.setName(resultSet.getString("NAME"));
            program.setIdChannelFk(resultSet.getLong("ID_CHAHHEL_FK"));
            program.setDatetime(resultSet.getDate("DATETIME"));
            program.setDuration(resultSet.getInt("DURATION"));
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
        return program;
    }

    @Override
    public void update(Program program) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PROGRAM SET NAME=?,DURATION=?,DATETIME=?,ID_CHANNEL_FK=0 WHERE ID=0";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, program.getName());
            preparedStatement.setInt(2, program.getDuration());
            preparedStatement.setDate(3, program.getDatetime());
            //preparedStatement.setLong(4, program.getIdChannelFk());
            //preparedStatement.setLong(5, program.getId());


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
    public void delete(Program program) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PROGRAM WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, program.getId());

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
