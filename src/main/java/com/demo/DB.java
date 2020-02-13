package com.demo;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author postgresqltutorial.com
 */
public class DB{

    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @param
     */
    public Connection connect(String appid, String serialno, String status) {
        ObjectMapper mapper = new ObjectMapper();
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            PreparedStatement pt = conn.prepareStatement("INSERT INTO \"test\" values(?,?,?)");
            pt.setString(1,appid);
            pt.setString(2,serialno);
            pt.setString(3,status);
            pt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }




}
