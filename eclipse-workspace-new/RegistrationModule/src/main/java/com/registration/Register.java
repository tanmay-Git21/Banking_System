package com.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends HttpServlet {

    // Database connection details
    private static final String url = "jdbc:mysql://localhost:3306/login_db";  // Database URL
    private static final String username = "root";  // Database username
    private static final String password = "iloveSql_21";  // Database password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve form parameters
        String name = request.getParameter("user_name");
        String pass = request.getParameter("user_pass");
        String email = request.getParameter("user_mail");

        PrintWriter out = response.getWriter();


        // JDBC code for saving this data in the SQL database
        try {
            // Establish a connection to the database
            Connection con = DriverManager.getConnection(url, username, password);

            // Prepare the SQL query
            String q = "INSERT INTO Users (name, password, email) VALUES (?, ?, ?)";

            // Create a PreparedStatement
            PreparedStatement pr = con.prepareStatement(q);

            // Set the parameters for the query
            pr.setString(1, name);
            pr.setString(2, pass);
            pr.setString(3, email);

            // Execute the query
            int result = pr.executeUpdate();

            if(result > 0) {
                out.println("<h1>Registration Successful!</h1>");
            } else {
                out.println("<h1>Registration Failed!</h1>");
            }

            // Close the resources
            pr.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>Registration Failed!</h1> " + e.getMessage());
        }
    }
}
