package com.monprojet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connexion = null;

        try {
            connexion = Connexion.getConnexion();
            System.out.println("Connexion réussie !");

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1- Lister les utilisateurs");
                System.out.println("2- Ajouter un utilisateur");
                System.out.println("3- Quitter");
                System.out.print("Choisissez une option: ");
                int choix = scanner.nextInt();
                scanner.nextLine(); // Pour consommer la nouvelle ligne

                switch (choix) {
                    case 1:
                        GestionUtilisateurs.listerUtilisateurs(connexion);
                        break;
                    case 2:
                        System.out.print("Entrez le nom: ");
                        String nom = scanner.nextLine();
                        System.out.print("Entrez l'email: ");
                        String email = scanner.nextLine();
                        System.out.print("Entrez l'ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Pour consommer la nouvelle ligne
                        GestionUtilisateurs.ajouterUtilisateur(connexion, nom, email, id);
                        break;
                    case 3:
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                    System.out.println("Connexion fermée avec succès.");
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
            scanner.close();
        }
    }
}