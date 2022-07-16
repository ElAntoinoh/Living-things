package Metier;

import java.util.ArrayList;

/**
 * La classe Classe gère la création et la gestion de Classes utilisables par des Personnages.
 * Elle hérite de la classe Statistics
 */
public class Classe extends Statistics {
    public static ArrayList<Classe> listeClasses = new ArrayList<>();

    /**
     * Constructeur de la classe Classe
     * @param nom Nom de la Classe
     * @param pv Points de vie gagnés à chaque niveau de la Classe
     * @param pm Points de magie gagnés à chaque niveau de la Classe
     * @param attaque Points d'attaque gagnés à chaque niveau de la Classe
     * @param attaqueMagique Points d'attaque magique gagnés à chaque niveau de la Classe
     * @param defense Points de défense gagnés à chaque niveau de la Classe
     * @param defenseMagique Points de défense magique gagnés à chaque niveau de la Classe
     */
    public Classe(String nom, int pv, int pm, int attaque, int attaqueMagique, int defense, int defenseMagique) {
        this.nom = nom;

        // Statistiques
        this.pv = pv;
        this.pm = pm;

        this.attaque        = attaque;
        this.attaqueMagique = attaqueMagique;

        this.defense        = defense;
        this.defenseMagique = defenseMagique;

        // Ajout de la Classe à la liste de toutes les Classes
        Classe.listeClasses.add(this);
    }

    public String toString() {
        return this.nom.toUpperCase() + ":\n" +
            String.format("  pv:      %4d | pm:              %4d\n", this.pv     , this.pm            ) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}