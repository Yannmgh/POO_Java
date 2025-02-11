import java.util.Scanner;

public class Main3 {
    public static void lireValeurTableau(int[] tableau, int index) {
        try {
            int valeur = tableau[index];  // Tentative d'accès à l'index donné
            System.out.println("Valeur à l'index " + index + " : " + valeur);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur : L'index " + index + " est hors limites ! Taille du tableau : " + tableau.length);
        } catch (Exception e) {
            System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] tableau = {10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un index : ");
        int index = scanner.nextInt();

        lireValeurTableau(tableau, index);

        scanner.close();
    }
}