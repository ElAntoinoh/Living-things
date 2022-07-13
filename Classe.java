import java.util.ArrayList;

public class Classe extends Statistics {
    static ArrayList<Classe> listeClasses = new ArrayList<>();

    public Classe(String nom, int pv, int pm, int attaque, int attaqueMagique, int defense, int defenseMagique) {
        this.nom = nom;

        this.pv = pv;
        this.pm = pm;

        this.attaque = attaque;
        this.attaqueMagique = attaqueMagique;

        this.defense = defense;
        this.defenseMagique = defenseMagique;

        Classe.listeClasses.add(this);
    }

    public String toString() {
        return this.nom.toUpperCase() + ":\n" +
            String.format("  pv:      %4d | pm:              %4d\n", this.pv     , this.pm            ) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}
