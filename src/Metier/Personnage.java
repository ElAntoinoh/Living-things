package Metier;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * La classe Personnage gère la création et la gestion de Personnages jouables.
 * Elle hérite de la classe Vivant
 */
public class Personnage extends Vivant {
    public static ArrayList<Personnage> listePersonnages = new ArrayList<>();

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
    // Une partie pour la tenue et une pour le reste des équipements
    private Equipement[] tenue;
    private Equipement[] stockEquipements;


    /**
     * Constructeur de la classe Personnage
     * @param nom Nom du Personnage
     * @param classe Classe du Personnage
     */
    public Personnage(String nom, Classe classe) {
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
        this.tenue            = new Equipement[6 ];
        this.stockEquipements = new Equipement[20];

        // Ajout du Personnage à la liste de tous les Personnages
        Personnage.listePersonnages.add(this);
    }


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
     * Méthode qui recalcule les statistiques d'un Personnage.
     * Appelée à un changer de Classe ou à une montée de niveau
     */
    private void recalculerStatistiques() {
        this.pvMax = this.pvBruts + this.niveau * this.classe.getPv();
        this.pmMax = this.pmBruts + this.niveau * this.classe.getPm();

        this.attaque        = this.attaqueBrute        + this.niveau * this.classe.getAttaque();
        this.attaqueMagique = this.attaqueMagiqueBrute + this.niveau * this.classe.getAttaqueMagique();

        this.defense        = this.defenseBrute        + this.niveau * this.classe.getDefense();
        this.defenseMagique = this.defenseMagiqueBrute + this.niveau * this.classe.getDefenseMagique();

        // Vérification que les points de vie et les points de magie ne dépassent pas leur maximum
        if( this.pv > this.pvMax ) this.pv = this.pvMax;
        if( this.pm > this.pmMax ) this.pm = this.pmMax;
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

    //#region Acesseurs
    public int                      getNiveau          () { return this.niveau;           }
    public HashMap<Classe, Integer> getClasses         () { return this.listeClasses;     }
    public Classe                   getClasse          () { return this.classe;           }
    public int                      getPvBruts         () { return this.pvBruts;          }
    public int                      getPmBruts         () { return this.pmBruts;          }
    public Equipement[]             getTenue           () { return this.tenue;            }
    public Equipement[]             getStockEquipements() { return this.stockEquipements; }
    //#endregion

    public String toString() {
        return String.format("%s (%s niveau %d)\n", this.nom.toUpperCase(), this.classe.getNom(), this.niveau) +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" + this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}