package com.monprojet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionUtilisateur {
    ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    Connexion link = null;

    public GestionUtilisateur(Connexion plink) {
        this.link = plink;
    }

    // Lister tous les utilisateurs
    public void listUtilisateurs() {
        try {
            Statement stmt = this.link.connexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nom, email FROM utilisateurs");
            System.out.println("Liste des utilisateurs:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");

                System.out.println("ID : " + id + ", Nom : " + nom + ", Email : " + email);
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    // Ajouter un utilisateur
    public void addUtilisateurs(Utilisateur utilisateur) {
        try {
            if (utilisateur.isValidNom()) {
                String sqlInsert = "INSERT INTO utilisateurs (nom, email) VALUES (?, ?)";
                PreparedStatement pstmtInsert = this.link.connexion.prepareStatement(sqlInsert);
                pstmtInsert.setString(1, utilisateur.getNom());
                pstmtInsert.setString(2, utilisateur.getEmail());
                pstmtInsert.executeUpdate();

                this.utilisateurs.add(utilisateur);
                System.out.println("Insertion réussie.");
            } else {
                System.out.println("Nom non valide !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    // Supprimer un utilisateur par son ID
    public void deleteUtilisateur(int id) {
        try {
            String sqlDelete = "DELETE FROM utilisateurs WHERE id = ?";
            PreparedStatement pstmtDelete = this.link.connexion.prepareStatement(sqlDelete);
            pstmtDelete.setInt(1, id);
            int rowsAffected = pstmtDelete.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès.");
            } else {
                System.out.println("Cet utilisateur n'existe pas");
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    // Éditer un utilisateur par son ID
    public void editUtilisateur(int id, String nouveauNom, String nouvelEmail) {
        try {
            String sqlUpdate = "UPDATE utilisateurs SET nom = ?, email = ? WHERE id = ?";
            PreparedStatement pstmtUpdate = this.link.connexion.prepareStatement(sqlUpdate);
            pstmtUpdate.setString(1, nouveauNom);
            pstmtUpdate.setString(2, nouvelEmail);
            pstmtUpdate.setInt(3, id);
            int rowsAffected = pstmtUpdate.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Utilisateur mis à jour avec succès.");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    // Rechercher un utilisateur par son nom ou son email
    public void searchUtilisateur(String searchTerm) {
        try {
            String sqlSearch = "SELECT id, nom, email FROM utilisateurs WHERE nom LIKE ? OR email LIKE ?";
            PreparedStatement pstmtSearch = this.link.connexion.prepareStatement(sqlSearch);
            pstmtSearch.setString(1, "%" + searchTerm + "%");
            pstmtSearch.setString(2, "%" + searchTerm + "%");
            ResultSet rs = pstmtSearch.executeQuery();

            System.out.println("Résultats de la recherche:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");

                System.out.println("ID : " + id + ", Nom : " + nom + ", Email : " + email);
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}