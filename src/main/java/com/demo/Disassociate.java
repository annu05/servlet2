package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/disassociate")
public class Disassociate extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String appid = request.getParameter("appid");
        String serialno = request.getParameter("serialno");

        System.out.println("appid: " + appid);
        System.out.println("serialno: " + serialno);

        // do some processing here...
        Dis dis = new Dis();
        String c=null;
        try {
            c = dis.disa(appid,serialno);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get response writer
        PrintWriter writer = response.getWriter();
        String home = "Home";
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<body style=\"  background: url(https://images.hdqwalls.com/download/alaska-glacier-ice-mountains-xy-2560x1440.jpg);  background-size: cover;\">";
        htmlRespone += "<div style=\" position: absolute;  top: 50%; left: 50%;  transform: translate(-50%,-50%); width: 586px; padding: 33px; background: rgba(0,0,0,0.8); box-sizing: border-box;  box-shadow: 0 15px 25px rgba(0,0,0,0.5); border-radius: 10px;\">";
        htmlRespone += "<h2 style=\"color:white;  text-align: center;  margin: 0 0 30px ; padding: 0;\">Your appid is: " + appid + "<br/>";
        htmlRespone += "Your serialno is: " + serialno + "<br/>";
        htmlRespone += "App association: " + c + "</h2>" + "<br/>";
        htmlRespone += "<a href=\"http://localhost:8080/untitled2_war/\" style=\"  background: transparent; border: none; outline: none ; color: #fff; background: #03a9f4; padding: 10px 20px; cursor: pointer;  border-radius: 5px; margin-left: 220px; \" >" + home + "</a>";
        htmlRespone += "</div>";
        htmlRespone += "</body>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);

    }

}
