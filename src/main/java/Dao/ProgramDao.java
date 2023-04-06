package Dao;

import Entity.Program;

import java.sql.SQLException;
import java.util.List;

public interface ProgramDao {


    //create
    void create(Program program) throws SQLException;

    //read
    List<Program> getAll() throws SQLException;

    Program getById(Long id) throws SQLException;
    //update

    void update(Program program) throws SQLException;

    //delete
    void delete(Program program) throws SQLException;

}
