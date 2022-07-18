package Metier;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * La classe Personnage gère la création et la gestion de Personnages jouables.
 * Elle hérite de la classe Vivant
 */
public class Personnage extends Vivant {
    public static ArrayList<Personnage> listePersonnages = new ArrayList<>();

    private static int nbPersonnages = 0;
    private int id;

    // Le personnage a une liste de classes déjà pratiquées
    // Chaque classe a un niveau indépendant des autres classes
    private HashMap<Classe, Integer> listeClasses;

    // Classe et niveau actuels
    private Classe classe;
    private int niveau;

    // Statistiques brutes
    // Elles sont inhérentes au personnage et ne varient pas selon la classe
    private int pvBruts;
    private int pmBruts;

    private int attaqueBrute;
    private int attaqueMagiqueBrute;

    private int defenseBrute;
    private int defenseMagiqueBrute;

    // Inventaire
    private Inventaire inventaire;

    /**
     * Constructeur de la classe Personnage
     * @param nom Nom du Personnage
     * @param classe Classe du Personnage
     */
    public Personnage(String nom, Classe classe) {
        this.id = Personnage.nbPersonnages++;

        this.nom = nom;

        // Initialisation de la liste des Classes du Personnage
        this.listeClasses = new HashMap<>();
        this.listeClasses.put(this.classe = classe, this.niveau = 1);

        // Statistiques
        this.pv = this.pvMax = this.pvBruts = 10;
        this.pm = this.pmMax = this.pmBruts = 5;

        this.attaque        = this.attaqueBrute        = 4;
        this.attaqueMagique = this.attaqueMagiqueBrute = 2;

        this.defense        = this.defenseBrute        = 4;
        this.defenseMagique = this.defenseMagiqueBrute = 2;

        // Inventaire
        this.inventaire = new Inventaire();

        // Ajout du Personnage à la liste de tous les Personnages
        Personnage.listePersonnages.add(this);
    }


    //#region Classes
    /**
     * Méthode appelée à la montée de niveau d'un Personnage.
     * Elle met à jour le niveau de la Classe actuelle puis recalcule ses statistiques
     */
    public void monterDeNiveau() {
        listeClasses.replace(classe, this.niveau++, this.niveau);

        recalculerStatistiques();

        // Les gains de points de vie et de magie s'appliquent également aux points de vie et magie actuels
        this.pv += this.classe.getPv();
        this.pm += this.classe.getPm();
    }


    /**
     * Remplace la Classe actuelle d'un Personnage par une autre
     * @param newClasse La nouvelle Classe du Personnage
     */
    public void changerDeClasse(Classe newClasse) {
        // S'il existe, on récupère le niveau actuel de la Classe
        if( this.listeClasses.containsKey(this.classe = newClasse) )
            this.niveau = this.listeClasses.get(this.classe);
        
        // Sinon, on le met à 1 et ajoute la Classe à la liste des Classes du Personnage
        else
            listeClasses.put(this.classe, this.niveau = 1);

        recalculerStatistiques();
    }
    //#endregion


    //#region Equipements
    /**
     * Insert un Equipement à la première place disponible dans l'inventaire du Personnage courant
     * @param equipement Equipement à insérer dans l'inventaire
     */
    public void recupererEquipement(Equipement equipement) {
        this.inventaire.recupererEquipement(equipement);
    }

    /**
     * Retire un Equipement du stock d'Equipement du Personnage courant
     * @param indice Indice de l'Equipement dans le tableau
     */
    public void jeterEquipement(int indice) {
        this.inventaire.jeterEquipement(indice);
    }

    public void equiper(int indice) {
        this.inventaire.equiper(indice);

        recalculerStatistiques();
    }

    public void desequiper(int indice) {
        this.inventaire.desequiper(indice);

        recalculerStatistiques();
    }
    //#endregion


    //#region Statistiques
    /**
     * Méthode qui recalcule les statistiques d'un Personnage.
     * Appelée à un changer de Classe, à une montée de niveau ou à l'ajout/retrait d'un équipement
     */
    private void recalculerStatistiques() {
        this.pvMax = this.pvBruts + (this.niveau - 1) * this.classe.getPv();
        this.pmMax = this.pmBruts + (this.niveau - 1) * this.classe.getPm();

        this.attaque        = this.attaqueBrute        + (this.niveau - 1) * this.classe.getAttaque();
        this.attaqueMagique = this.attaqueMagiqueBrute + (this.niveau - 1) * this.classe.getAttaqueMagique();

        this.defense        = this.defenseBrute        + (this.niveau - 1) * this.classe.getDefense();
        this.defenseMagique = this.defenseMagiqueBrute + (this.niveau - 1) * this.classe.getDefenseMagique();

        // Prise en compte des équipements du Personnage
        for( Equipement equipement : this.inventaire.getTenue() ) {
            if( equipement == null ) continue;
            
            this.pvMax += equipement.getPv();
            this.pmMax += equipement.getPm();

            this.attaque        += equipement.getAttaque();
            this.attaqueMagique += equipement.getAttaqueMagique();

            this.defense        += equipement.getDefense();
            this.defenseMagique += equipement.getDefenseMagique();
        }

        // Vérification que les points de vie et les points de magie ne dépassent pas leur maximum
        if( this.pv > this.pvMax ) this.pv = this.pvMax;
        if( this.pm > this.pmMax ) this.pm = this.pmMax;
    }
    //#endregion


    //#region Acesseurs
    public int                      getIDJoueur  () { return this.id;           }
    public int                      getNiveau    () { return this.niveau;       }
    public HashMap<Classe, Integer> getClasses   () { return this.listeClasses; }
    public Classe                   getClasse    () { return this.classe;       }
    public int                      getPvBruts   () { return this.pvBruts;      }
    public int                      getPmBruts   () { return this.pmBruts;      }
    public Inventaire               getInventaire() { return this.inventaire;   }
    //#endregion


    /**
     * Renvoie le Personnage associé à l'indice passé en paramètre
     * @param id Indice du Personnage
     * @return Personnage recherché ou null si inexistant
     */
    public static Personnage getPersonnageByID(int id) {
        for( Personnage personnage : Personnage.listePersonnages )
            if( personnage.getIDJoueur() == id )
                return personnage;
        
        return null;
    }


    public String toString() {
        int taille = 1;

        // Récupération de la longueur du nom d'équipement le plus long des équipements de la tenue
        for( Equipement equipement : this.inventaire.getTenue() )
            if( equipement != null ) {
                // On ne prend pas en compte l'arme du Personnage
                if( equipement.getType().equals("arme") ) continue;

                if( taille < equipement.getNom().length() )
                    taille = equipement.getNom().length();
            }

        String str = "";
        
        // Statistiques du Personnage
        str +=
            String.format("%s (%s niveau %d)\n", this.nom.toUpperCase(), this.classe.getNom(), this.niveau) +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" + this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);

        // Trait de séparation
        str += String.format("- - - - - - - - - - - - - - - - - - - -\n");

        // Affichage de la tenue du Personnage
        str += String.format("[%" + taille + "s] ", this.inventaire.getTete() != null ? this.inventaire.getTete().getNom() : " " );
        str += "[" + ( this.inventaire.getArme() != null ? this.inventaire.getArme().getNom() : " " ) + "]\n";

        str += String.format("[%-" + taille + "s]\n", this.inventaire.getTorse () != null ? this.inventaire.getTorse ().getNom() : " " );
        str += String.format("[%-" + taille + "s]\n", this.inventaire.getJambes() != null ? this.inventaire.getJambes().getNom() : " " );
        str += String.format("[%-" + taille + "s]\n", this.inventaire.getMains () != null ? this.inventaire.getMains ().getNom() : " " );
        str += String.format("[%-" + taille + "s]\n", this.inventaire.getPieds () != null ? this.inventaire.getPieds ().getNom() : " " );
        
        return str;
    }
}