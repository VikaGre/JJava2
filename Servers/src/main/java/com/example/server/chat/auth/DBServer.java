package com.example.server.chat.auth;

import java.sql.*;

public class DBServer {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) throws SQLException {

        readEx();

        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void readEx() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");
            while (rs.next()) {
                System.out.printf("%s - %s - %s", rs.getString("Login"), rs.getString("Password"), rs.getString("Username"));

        }
    }

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/db/ChatLoginAndPassword.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
