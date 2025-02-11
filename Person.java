public class Person {
// Attributs
private String nom;
private int age;
// Constructeur par defaut
public Person() {
this. nom = "";
this. age = 0;
}
// Constructeur avec parametres
public Person(String non, int age) {
this.nom = nom;
this. age = age;
 }
// Mhéthode pour se présenter 
public void sePresenter() {
System.out.println("Je m'appelle " + this.nom + " et j'ai " + this.age + " ans.")
}
}