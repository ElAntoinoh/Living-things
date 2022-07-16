package Metier;

import java.util.ArrayList;

/**
 * La classe Monstre gère la création et la gestion de Monstres affrontables par des Personnages.
 * Elle hérite de la classe Vivant
 */
public class Monstre extends Vivant {
    public static ArrayList<Monstre> listeMonstres = new ArrayList<>();

    /**
     * Constructeur de la classe Monstre
     * @param nom Nom du monstre
     * @param pv Points de vie du monstre
     * @param pm Points de magie du monstre
     * @param attaque Points d'attaque du monstre
     * @param attaqueMagique Points d'attaque magique du monstre
     * @param defense Points de défense du monstre
     * @param defenseMagique Points de défense magique du monstre
     */
    public Monstre(String nom, int pv, int pm, int attaque, int attaqueMagique, int defense, int defenseMagique) {
        this.nom = nom;

        // Statistiques
        this.pv = this.pvMax = pv;
        this.pm = this.pmMax = pm;

        this.attaque        = attaque;
        this.attaqueMagique = attaqueMagique;

        this.defense        = defense;
        this.defenseMagique = defenseMagique;

        // Ajout du monstre à la liste de tous les monstres
        Monstre.listeMonstres.add(this);
    }

    public String toString() {
        return this.nom.toUpperCase() + "\n" +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" + this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}