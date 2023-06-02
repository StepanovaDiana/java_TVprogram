package crud;

import DaoImpl.ProgramDaoIml;
import Entity.Program;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProgramTest {

    public final ProgramDaoIml programDaoIml=new ProgramDaoIml();
    public final Program p=new Program();

    @Test
    public void insertTest()throws  Exception{
        init();
        assertEquals(p.getId(),programDaoIml.getById(p.getId()).getId());
    }
    @Test
    public void deleteTest()throws  Exception{
        init();
        programDaoIml.delete(p.getId());
        assertNull(programDaoIml.getById(p.getId()));
    }
    @Test
    public void updateTest() throws SQLException {
        init();
        p.setName("музыка");
        p.setDuration(60);
        Date timestamp = new Date(System.currentTimeMillis());
        p.setDatetime(timestamp);
        p.setIdChannelFk(2);
        programDaoIml.update(p);
        assertEquals(p.getName(), programDaoIml.getById(p.getId()).getName());

    }
    @Test
    public void getAllTest() {
        List<Program> p = programDaoIml.getAll();
        assertEquals(p.size(),programDaoIml.getAll().size());
    }

    @Test
    public void getByTest() throws SQLException {
        init();
        assertEquals(p.getId(),programDaoIml.getById(p.getId()).getId() );
    }

    void init() throws SQLException{
        p.setName("музыка");
        p.setDuration(60);
        Date timestamp = new Date(System.currentTimeMillis());
        p.setDatetime(timestamp);
        p.setIdChannelFk(2);
        Program program=programDaoIml.insert(p);
        p.setId(program.getId());

    }
}

