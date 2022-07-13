import java.util.ArrayList;
import java.util.Arrays;

public class Personnage extends Vivant {
    static ArrayList<Personnage> listePersonnages = new ArrayList<>();

    private int niveau;

    // Classes
    private ArrayList<Classe> listeClasses;
    private Classe classe;

    public Personnage(String nom, Classe classe) {
        this.nom    = nom;
        this.niveau = 1;

        // Classes
        this.listeClasses = new ArrayList<>(Arrays.asList(classe));
        this.classe = classe;

        this.pv = this.pvMax = 10;
        this.pm = this.pmMax = 5;

        this.attaque        = 4;
        this.attaqueMagique = 2;

        this.defense        = 4;
        this.defenseMagique = 2;

        Personnage.listePersonnages.add(this);
    }

    // Accesseurs
    public int               getNiveau () { return this.niveau;       }
    public ArrayList<Classe> getClasses() { return this.listeClasses; }
    public Classe            getClasse () { return this.classe;       }

    public String toString() {
        return String.format("%s (%s niveau %d)\n", this.nom.toUpperCase(), this.classe.getNom(), this.niveau) +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" + this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}