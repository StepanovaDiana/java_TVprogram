package org.example;

import Entity.User;
import Service.ChannelService;
import Service.ProgramService;
import Service.UserChannelListService;
import Service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService=new UserService();
        ChannelService channelService= new ChannelService();
        UserChannelListService userChannelListService= new UserChannelListService();
        ProgramService programService= new ProgramService();

        User user= new User();
        user.setName("SashaPr");
        user.setEmail("sashaprot@gmail.com");
        user.setPassword("1234567089");
        // userService.create(user);
        // userService.delete(3);
        userService.update(user);

       /* Channel channel=new Channel();
        channel.setName("стс");

        Program program=new Program();
        program.setName("Однажды в России");
        program.setDuration(60);
        program.setDatetime(Date.valueOf("2022-10-17"));
        program.setIdChannelFk(channel.getId());

        UserChannelList userChannelList=new UserChannelList();
        userChannelList.setFavorite(true);
        userChannelList.setIdUserFk(user.getId());
        userChannelList.setIdChannelFk(channel.getId());*/

        //insert
     /* try{
            userService.create(user);
            channelService.create(channel);
            programService.create(program);
            userChannelListService.create(userChannelList);


        } catch (SQLException e){
            e.printStackTrace();
        }*/
        //update
       /*try{
            userService.update(user);
            channelService.update(channel);
            programService.update(program);
            userChannelListService.update(userChannelList);


        } catch (SQLException e){
            e.printStackTrace();
        }*/


        //delete
        /*try{
            userService.delete(user);
            channelService.delete(channel);
            programService.delete(program);
           // userChannelListService.delete(userChannelList);


        } catch (SQLException e){
            e.printStackTrace();
        }*/


    }
}