public class Livre extends Produit {
    
    private static final double TAXE_LIVRE = 0.05;

    public Livre(double prixBase){
        super(prixBase);
    }

    @Override
    public double calculerPrix() {
        return prixBase * (1 + TAXE_LIVRE);
    }
}
