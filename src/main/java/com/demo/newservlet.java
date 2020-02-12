package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/new")
public class newservlet extends HttpServlet
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
            ResultSet rs = stmt.executeQuery("select * from assets");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>productTypeName</th><th>productTypeId</th><th>pricingParam</th><th>adamIdStr</th><th>isIrrevocable</th><th>deviceAssignable</th><tr>");
            while (rs.next())
            {
                String a = rs.getString("productTypeName");
                String b = rs.getString("productTypeId");
                String c = rs.getString("pricingParam");
                String d = rs.getString("adamIdStr");
                String e = rs.getString("isIrrevocable");
                String f = rs.getString("deviceAssignable");

                out.println("<tr><td>" + a + "</td><td>"+ b +"</td><td>"+ c +"</td><td>" + d + "</td><td>" + e + "</td><td>" + f + "</td></tr>");
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


