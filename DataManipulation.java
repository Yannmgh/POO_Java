public class DataManipulation {

    public void main(String[] args){
        int[] tableau = {3, 5, 7, 9, 18, 12, 15, 4, 6};

        double somme = 0;
        for (int num : tableau) {
            somme += num;
    }
    double moyenne = somme / tableau.length;
    System.out.println("Moyenne : " + moyenne);



    
}
}
