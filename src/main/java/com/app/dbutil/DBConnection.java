package com.app.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    static {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            System.out.println("Driver Loaded !!");

            String url = "jdbc:mysql://localhost:3306/task_db";
            String username = "root";
            String password = "abhi";

            conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to DB !!");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
            System.out.print("Connection Closed !! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
