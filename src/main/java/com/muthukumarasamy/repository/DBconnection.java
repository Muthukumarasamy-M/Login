package com.muthukumarasamy.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public static final String URL = "jdbc:mysql://localhost:3306/Logindata";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Muthukumar@123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Explicitly load the JDBC driver class
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            throw new SQLException("JDBC Driver not found", e);
        }

        // Use try-with-resources to automatically close the connection
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            throw e; // Rethrow the exception to propagate it
        }
    }
}

