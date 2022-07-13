import java.util.ArrayList;

public class Classe {
    static ArrayList<Classe> listeClasses = new ArrayList<>();
    
    private String nom;

    private int pv;
    private int pm;

    private int attaque;
    private int attaqueMagique;

    private int defense;
    private int defenseMagique;

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

    // Accesseurs
    public String getNom           () { return this.nom;            }
    public int    getPv            () { return this.pv;             }
    public int    getPm            () { return this.pm;             }
    public int    getAttaque       () { return this.attaque;        }
    public int    getAttaqueMagique() { return this.attaqueMagique; }
    public int    getDefense       () { return this.defense;        }
    public int    getDefenseMagique() { return this.defenseMagique; }

    public String toString() {
        return this.nom.toUpperCase() + ":\n" +
            String.format("  pv:      %4d | pm:              %4d\n", this.pv     , this.pm            ) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}
