package org.example;

import Entity.Channel;
import Entity.Program;
import Service.ChannelService;
import Service.ProgramService;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ChannelService channelService= new ChannelService();
        ProgramService programService= new ProgramService();
        Channel channel=new Channel();
        channel.setName("pop");
        //channelService.delete(1);
        //channelService.insert(channel);
        //channelService.update(channel);

        Program program=new Program();
        program.setId(2);
        program.setName("Однажды в России");
        program.setDuration(60);
        program.setDatetime(Date.valueOf("2022-10-17"));
        program.setIdChannelFk(channel.getId());
        programService.insert(program);





    }
}