package com.demo;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBD{

    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";


    public Connection connect(String appid, String serialno, String status) {
        ObjectMapper mapper = new ObjectMapper();
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            PreparedStatement pt = conn.prepareStatement("DELETE FROM test WHERE appid = ? AND serialno = ?");
            pt.setString(1,appid);
            pt.setString(2,serialno);
            pt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }




}
