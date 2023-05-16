package org.example;

import DaoImpl.ChannelDaoImpl;
import Entity.Channel;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ChannelDaoImpl channell= new ChannelDaoImpl();
        //ProgramDaoIml programService= new ProgramDaoIml();
        List<Channel> channels=channell.getAll();
        for(int i =0;i<channels.size();i++){
            System.out.println(channels.get(i));
        }






    }
}