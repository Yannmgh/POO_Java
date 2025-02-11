public class DVD extends Produit {

    private static final double TAXE_DVD = 0.2; // Taxe de 20%

    public DVD(double prixBase) {
        super(prixBase);
    }

    @Override
    public double calculerPrix() {
        return prixBase * (1 + TAXE_DVD);
    }
    
}
