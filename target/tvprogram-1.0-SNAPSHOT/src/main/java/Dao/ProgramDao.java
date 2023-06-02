package Dao;

import Entity.Program;

import java.sql.SQLException;
import java.util.List;

public interface ProgramDao {


    //create
    public Program insert(Program program) throws SQLException;

    public Program getById(long id) throws SQLException;

    public List<Program> getAllForChannel(long channelId) throws Exception;

    public void update(Program program) throws SQLException;

    public void delete(long id) throws SQLException;

}
