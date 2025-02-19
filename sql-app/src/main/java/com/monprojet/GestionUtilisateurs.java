package com.monprojet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionUtilisateurs {

    public static void listerUtilisateurs(Connection connexion) throws SQLException {
        String sql = "SELECT * FROM utilisateurs";
        try (Statement stmt = connexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Nom: " + nom + ", Email: " + email);
            }
        }
    }

    public static void ajouterUtilisateur(Connection connexion, String nom, String email, int id) throws SQLException {
        String sqlInsert = "INSERT INTO utilisateurs (nom, email, Id) VALUES ('" + nom + "', '" + email + "', '" + id + "')";
        try (Statement stmt = connexion.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sqlInsert);
            System.out.println("Insertion réussie, nombre de lignes affectées : " + rowsAffected);
        }
    }
}