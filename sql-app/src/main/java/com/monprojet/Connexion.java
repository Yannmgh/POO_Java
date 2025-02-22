package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/ma_base";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }
}