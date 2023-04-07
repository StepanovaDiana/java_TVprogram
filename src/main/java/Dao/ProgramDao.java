package Dao;

import Entity.Program;

import java.sql.SQLException;

public interface ProgramDao {


    //create
    public void insert(Program program) throws SQLException;

    public Program getById(long id) throws SQLException;

    public void update(Program program) throws SQLException;

    public void delete(long id) throws SQLException;

}
