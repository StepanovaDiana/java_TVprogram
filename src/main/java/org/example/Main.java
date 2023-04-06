package org.example;

import Entity.Channel;
import Entity.Program;
import Entity.User;
import Entity.UserChannelList;
import Service.ChannelService;
import Service.ProgramService;
import Service.UserChannelListService;
import Service.UserService;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService=new UserService();
        ChannelService channelService= new ChannelService();
        UserChannelListService userChannelListService= new UserChannelListService();
        ProgramService programService= new ProgramService();

        User user= new User();
        user.setName("Diana");
        user.setEmail("sasha@gmail.com");
        user.setPassword("12345670");

        Channel channel=new Channel();
        channel.setName("ТНТ");

        Program program=new Program();
        program.setName("Однажды в России");
        program.setDuration(60);
        program.setDatetime(Date.valueOf("2022-10-17"));
        program.setIdChannelFk(channel.getId());

        UserChannelList userChannelList=new UserChannelList();
        userChannelList.setFavorite(true);
        userChannelList.setIdUserFk(user.getId());
        userChannelList.setIdChannelFk(channel.getId());

        //create
     /* try{
            userService.create(user);
            channelService.create(channel);
            programService.create(program);
            userChannelListService.create(userChannelList);


        } catch (SQLException e){
            e.printStackTrace();
        }*/
        //getAll
       /* try{
            userService.getAll();
            channelService.getAll();
            programService.getAll();
            userChannelListService.getAll();


        } catch (SQLException e){
            e.printStackTrace();
        }*/


        //delete
        try{
            userService.delete(user);
            channelService.delete(channel);
            programService.delete(program);
            userChannelListService.delete(userChannelList);


        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}