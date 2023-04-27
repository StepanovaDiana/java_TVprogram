package DaoImpl;

import Dao.ProgramDao;
import Entity.Program;
import connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramDaoIml extends ConnectionManager implements ProgramDao {


    @Override
    public void insert(Program program) throws SQLException {
        PreparedStatement preparedStatement
                = null;
        String sql = "INSERT INTO public.Program ( NAME, ID_CHANNEL_FK, DURATION, DATETIME)" + "VALUES(?,?,?,?)";

        try(Connection connection=ConnectionManager.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, program.getName());
            preparedStatement.setLong(2, program.getIdChannelFk());
            preparedStatement.setInt(3, program.getDuration());
            preparedStatement.setDate(4, program.getDatetime());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    @Override
    public Program getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID,NAME,DURATION,DATETIME,ID_CHANNEL_FK FROM public.PROGRAM WHERE ID=? ";

        try(Connection connection=ConnectionManager.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Program program = new Program();
                program.setId(resultSet.getLong("ID"));
                program.setName(resultSet.getString("NAME"));
                program.setIdChannelFk(resultSet.getLong("ID_CHAHHEL_FK"));
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

    @Override
    public void update(Program program) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE public.PROGRAM SET NAME=?,DURATION=?,DATETIME=?,ID_CHANNEL_FK=?" + " WHERE ID=?";
        try(Connection connection=ConnectionManager.getConnection()) {
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

        try (Connection connection=ConnectionManager.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
