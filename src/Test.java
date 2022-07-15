public class Test {
    public static void main(String[] args) {
        Classe c1 = new Classe("Guerrier"   , 1, 2, 3, 4, 5, 6);
        Classe c2 = new Classe("Mage"       , 6, 5, 4, 3, 2, 1);
        Classe c3 = new Classe("Classe vide", 0, 0, 0, 0, 0, 0);

        Personnage p = new Personnage("Antoine", c1);
    }
}
