package Dao;

import Entity.Program;

import java.sql.SQLException;

public interface ProgramDao {


    //create
    void create(Program program) throws SQLException;


    Program getById(Long id) throws SQLException;
    //update

    void update(Program program) throws SQLException;

    //delete
    void delete(long id) throws SQLException;

}
