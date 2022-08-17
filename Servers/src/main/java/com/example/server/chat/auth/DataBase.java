package com.example.server.chat.auth;

import java.sql.*;

public class DataBase {

    public static Connection conn;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setConn();
        createDB();
        writeBD();
        readBD();
        closeDB();
    }

    public static void setConn() throws ClassNotFoundException, SQLException {
        conn = null;
        // загрузить драйвер в память виртуальной машины;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Servers/src/main/resources/db/ChatLoginAndPassword.db");
    }

    public static void createDB() throws SQLException {
        statement = conn.createStatement();
        statement.execute(
                "CREATE TABLE if not exists 'Users'" +
                        "('ID' INTEGER PRIMARY KEy AUTOINCREMENT, 'Login' text, 'Password' text, 'Username', text);");
    }

    public static void writeBD() throws SQLException {
        statement.execute("INSERT INTO 'Users' ('Login', 'Password', 'Username') VALUES ('UserMax', 'Max', 123)");
        statement.execute("INSERT INTO 'Users' ('Login', 'Password', 'Username') VALUES ('UserEgor', 'Egor', 123)");

    }

    public static void readBD() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Users");
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String login = resultSet.getString("Login");
            String password = resultSet.getString("Password");
            String username = resultSet.getString("Username");
            System.out.println(id + " " + login + " " + password + " " + username);
        }
    }
    public static String checkPass(String login,String password) throws SQLException, ClassNotFoundException {
        setConn();
        createDB();
        resultSet = statement.executeQuery("SELECT * FROM Users");

        if (resultSet.isClosed()) {
            return null;
        }

        while (resultSet.next()) {

            String loginFromDB = resultSet.getString("Login");
            String passwordFromDB = resultSet.getString("Password");

            if((passwordFromDB.equals(password)) && (loginFromDB.equals(login))){
                closeDB();
            }
        }
        return null;
    }

    public static void closeDB() throws SQLException {
        resultSet.close();
        statement.close();
        conn.close();
    }
}
