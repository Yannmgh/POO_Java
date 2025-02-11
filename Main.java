public class Main {

    public static void main(String[] args) {
        Produit livre = new Livre(50.0);
        Produit dvd = new DVD(50.0);
        Produit produitGenerique = new Produit(50.0);

        System.out.println("Prix du livre : " + livre.calculerPrix() + " €");
        System.out.println("Prix du DVD : " + dvd.calculerPrix() + " €");
        System.out.println("Prix du produit générique : " + produitGenerique.calculerPrix() + " €");
    }
    
}
