package Metier;

import java.util.ArrayList;

public class Monstre extends Vivant {
    public static ArrayList<Monstre> listeMonstres = new ArrayList<>();

    public Monstre(String nom, int pv, int pm, int attaque, int attaqueMagique, int defense, int defenseMagique) {
        this.nom = nom;

        this.pv = this.pvMax = pv;
        this.pm = this.pmMax = pm;

        this.attaque        = attaque;
        this.attaqueMagique = attaqueMagique;

        this.defense        = defense;
        this.defenseMagique = defenseMagique;

        Monstre.listeMonstres.add(this);
    }

    public String toString() {
        return this.nom.toUpperCase() + "\n" +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" + this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}