package com.demo;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBT{

    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";


    public Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }

    public String testing(String appid,String serialno) {


        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM test WHERE appid LIKE ? AND serialno LIKE ? ")) {
             pstmt.setString(1,appid);
             pstmt.setString(2,serialno);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("appid"));
                System.out.println(rs.getString("serialno"));
                if(appid.equals(rs.getString("appid")) && serialno.equals(rs.getString("serialno"))){
                    return "License already assigned";
                }else
                    return "app is not assosiated";

            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "app is not assosiated";

    }




}
