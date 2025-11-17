package com.example.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Simple demo credentials
    private final String[][] users = {
        {"faculty1", "pass123"},
        {"faculty2", "admin456"},
        {"profA", "profA123"}
    };

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean valid = false;

        for(String[] user : users){
            if(user[0].equals(username) && user[1].equals(password)){
                valid = true;
                break;
            }
        }

        if(valid){
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Redirect to timetable page
            response.sendRedirect("timetable.html");
        } else {
            // Invalid credentials
