package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/DemoServlet")
public class Display extends HttpServlet {




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        App app = new App();
        app.connect();





        out.println("<h1>"+ app.getActors() + "</h1>");
    }



}
