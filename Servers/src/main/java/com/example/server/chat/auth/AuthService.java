package com.example.server.chat.auth;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;
    public void connectToDB() {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
    /*private static Set<User> USERS = Set.of(
            new User("login1", "pass1", "username1"),
            new User("login2", "pass2", "username2"),
            new User("login3", "pass3", "username3")
    );*/

   /* public String getUsernameByLoginAndPassword(String login, String password) {
        User requiredUser = new User(login, password);
        for (User user : USERS) {
            if (requiredUser.equals(user)) {
                return user.getUsername();
            }
        }

        return null;
    }*/

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/db/ChatLoginAndPassword.db");
        stmt = connection.createStatement();
    }

        public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUsernameByLoginAndPassword (String login, String password) throws SQLException {
        ResultSet rs = stmt.executeQuery(String.format("SELECT * from auth WHERE login = '%s'", login));

        if (rs.isClosed()) {
            return null;
        }

        String usernameDB = rs.getString("Username");
        String passwordDB = rs.getString("Password");


        return ((passwordDB != null) && (passwordDB.equals(password))) ? usernameDB : null;
    }
}
