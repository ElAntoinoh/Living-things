package Metier;

import java.util.ArrayList;

/**
 * La classe Equipement gère la création et la gestion des Equipements équipables par des Personnages.
 * Elle hérite de la classe Statistics
 */
public class Equipement extends Statistics {
    public static ArrayList<Equipement> listeEquipements = new ArrayList<>();

    // Type d'équipement ( arme, tête, torse, mains, jambes, pieds )
    private String type;

    /**
     * Constructeur de la classe Equipement
     * @param nom Nom de l'équipement
     * @param type Type de l'équipement
     * @param pv Points de vie gagnés grâce à l'équipement
     * @param pm Points de magie gagnés grâce à l'équipement
     * @param attaque Points d'attaque gagnés grâce à l'équipement
     * @param attaqueMagique Points d'attaque magique gagnés grâce à l'équipement
     * @param defense Points de défense gagnés grâce à l'équipement
     * @param defenseMagique Points de défense magique gagnés grâce à l'équipement
     */
    public Equipement(String nom, String type, int pv, int pm, int attaque, int attaqueMagique, int defense, int defenseMagique) {
        this.nom = nom;
        this.type = type;

        // Statistiques
        this.pv = pv;
        this.pm = pm;

        this.attaque        = attaque;
        this.attaqueMagique = attaqueMagique;

        this.defense        = defense;
        this.defenseMagique = defenseMagique;

        // Ajout de l'équipement à la liste de tous les équipements
        Equipement.listeEquipements.add(this);
    }

    //#region Accesseurs
    public String getType() { return this.type; }
    //#endregion

    public String toString() {
        return this.nom.toUpperCase() + "(" + this.type + "):\n" +
            String.format("  pv:      %4d | pm:              %4d\n", this.pv     , this.pm            ) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}