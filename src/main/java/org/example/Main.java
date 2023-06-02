package org.example;

import DaoImpl.ProgramDaoIml;
import Entity.Program;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //ChannelDaoImpl channell= new ChannelDaoImpl();
        ProgramDaoIml programService= new ProgramDaoIml();
        Program programs=new Program();
       // programs.setId(1);
        programs.setName("music");
        programs.setDuration(60);
        programs.setIdChannelFk(3);
        Date timestamp = new Date(System.currentTimeMillis());
        programs.setDatetime(timestamp);
        programService.insert((programs));
       // List<Channel> channels=channell.getAll();






    }
}