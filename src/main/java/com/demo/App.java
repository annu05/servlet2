package com.demo;

import java.sql.*;

public class App{

    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";

    public Connection connect() {
        Connection conn = null;
        try {
           Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public ResultSet getActors() {

        String SQL = "SELECT * FROM rest";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayActor(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public String displayActor(ResultSet rs) throws SQLException {
       while (rs.next()) {
           String n = rs.getString("clientContext");
           return n;
       }

        return null;
    }

    public static void main(String[] args) {
        App app = new App();
        app.connect();
        app.getActors();
    }
}