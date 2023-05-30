package service;

import DaoImpl.ProgramDaoIml;
import Entity.Program;

import java.sql.SQLException;
import java.util.List;

public class ProgramService {

    private final ProgramDaoIml programDaoIml;

    public ProgramService() {
        this.programDaoIml = new ProgramDaoIml();

    }
    public void insert(Program program){
        try{
            programDaoIml.insert(program);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Program getById(long id){
        try{
            return programDaoIml.getById(id);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Program> loadProgram(long channelId) {
        try{
            return programDaoIml.getAllForChannel(channelId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Program> getAll(long channelId){
        try{
            return programDaoIml.getAllForChannel( channelId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Program program){
        try{
            programDaoIml.update(program);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(long id){
        try{
            programDaoIml.delete(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
