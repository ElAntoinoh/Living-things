package Metier;

import java.util.ArrayList;

public class Equipement extends Statistics {
    public static ArrayList<Equipement> listeEquipements = new ArrayList<>();

    private String type;

    public Equipement(String nom, String type, int pv, int pm, int attaque, int attaqueMagique, int defense, int defenseMagique) {
        this.nom = nom;
        this.type = type;

        this.pv = pv;
        this.pm = pm;

        this.attaque        = attaque;
        this.attaqueMagique = attaqueMagique;

        this.defense        = defense;
        this.defenseMagique = defenseMagique;

        Equipement.listeEquipements.add(this);
    }

    public String getType() { return this.type; }

    public String toString() {
        return this.nom.toUpperCase() + "(" + this.type + "):\n" +
            String.format("  pv:      %4d | pm:              %4d\n", this.pv     , this.pm            ) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}