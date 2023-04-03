package org.example;

import connection.ConnectionManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ConnectionManager conect = new ConnectionManager();
        conect.getConnection();
    }
}