package org.example;

import Entity.Channel;
import Entity.Program;
import DaoImpl.ChannelDaoImpl;
import DaoImpl.ProgramDaoIml;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ChannelDaoImpl channell= new ChannelDaoImpl();
        ProgramDaoIml programService= new ProgramDaoIml();
        Channel channel=new Channel();
        channel.setName("pop");
        //channell.delete(1);
        channell.insert(channel);
        //channell.update(channel);

        Program program=new Program();
        program.setId(2);
        program.setName("Однажды в России");
        program.setDuration(60);
        program.setDatetime(Date.valueOf("2022-10-17"));
        program.setIdChannelFk(channel.getId());
        programService.insert(program);





    }
}