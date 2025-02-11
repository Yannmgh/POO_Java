import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestionEtudiants {
    private List<Etudiant> etudiants = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Menu principal
    public void demarrer() {
        while (true) {
            System.out.println("\n--- Gestion des Étudiants ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher la liste des étudiants");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            int choix;
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
                continue;
            }

            switch (choix) {
                case 1:
                    ajouterEtudiant();
                    break;
                case 2:
                    afficherEtudiants();
                    break;
                case 3:
                    supprimerEtudiant();
                    break;
                case 4:
                    System.out.println("Fermeture du programme...");
                    return;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    // Ajouter un étudiant
    public void ajouterEtudiant() {
        System.out.print("Entrez le nom de l'étudiant : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom de l'étudiant : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez la classe de l'étudiant : ");
        String classe = scanner.nextLine();

        etudiants.add(new Etudiant(nom, prenom, classe));
        System.out.println("Étudiant ajouté avec succès !");
    }

    // Afficher la liste des étudiants
    public void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant dans la liste.");
        } else {
            System.out.println("Liste des étudiants :");
            for (Etudiant e : etudiants) {
                System.out.println("- " + e);
            }
        }
    }

    // Supprimer un étudiant par son nom
    public void supprimerEtudiant() {
        System.out.print("Entrez le nom de l'étudiant à supprimer : ");
        String nom = scanner.nextLine();
        Iterator<Etudiant> iterator = etudiants.iterator();
        boolean trouve = false;

        while (iterator.hasNext()) {
            Etudiant e = iterator.next();
            if (e.getNom().equalsIgnoreCase(nom)) {
                iterator.remove();
                trouve = true;
                System.out.println("Étudiant supprimé avec succès !");
                break;
            }
        }

        if (!trouve) {
            System.out.println("Aucun étudiant trouvé avec ce nom.");
        }
    }

    
}