public class Test {
    public static void main(String[] args) {
        Classe c = new Classe("Guerrier", 1, 2, 3, 4, 5, 6);

        Personnage p = new Personnage("Antoine", c);

        Monstre m = new Monstre("Crazboizoc", 1, 2, 3, 4, 5, 6);

        System.out.println(p);
        System.out.println(p.getClasse());
        System.out.println(m);
    }
}
