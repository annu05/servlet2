package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/r")
public class r extends HttpServlet
{
    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<html><body>");
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rest");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>location</th><th>clientContext</th><th>uId</th><th>users</th><tr>");
            while (rs.next())
            {
                String n = rs.getString("location");
                String a = rs.getString("clientContext");
                String b = rs.getString("uId");
                String c = rs.getString("users");

                out.println("<tr><td>" + n + "</td><td>"+ a +"</td><td>"+ b +"</td><td>" + c +"</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            conn.close();
        }
        catch (Exception e)
        {
            out.println("error");
        }
    }
}

