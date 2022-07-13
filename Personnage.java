import java.util.ArrayList;
import java.util.Arrays;

public class Personnage {
    static ArrayList<Personnage> listePersonnages = new ArrayList<>();

    private String nom;
    private int    niveau;

    // Classes
    private ArrayList<Classe> listeClasses;
    private Classe classe;

    // Statistiques
    private int pvMax;
    private int pmMax;

    private int attaque;
    private int attaqueMagique;

    private int defense;
    private int defenseMagique;

    // Semi-statistiques
    private int pv;
    private int pm;

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
    public String            getNom           () { return this.nom;            }
    public int               getNiveau        () { return this.niveau;         }
    public ArrayList<Classe> getClasses       () { return this.listeClasses;   }
    public Classe            getClasse        () { return this.classe;         }
    public int               getPv            () { return this.pv;             }
    public int               getPvMax         () { return this.pvMax;          }
    public int               getPm            () { return this.pm;             }
    public int               getPmMax         () { return this.pmMax;          }
    public int               getAttaque       () { return this.attaque;        }
    public int               getAttaqueMagique() { return this.attaqueMagique; }
    public int               getDefense       () { return this.defense;        }
    public int               getDefenseMagique() { return this.defenseMagique; }

    public String toString() {
        return String.format("%s (%s niveau %d)\n", this.nom.toUpperCase(), this.classe.getNom(), this.niveau) +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" +this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }

    public static void main(String[] args) {
        Classe c = new Classe("Guerrier", 1, 2, 3, 4, 5, 6);

        Personnage p = new Personnage("Antoine", c);

        System.out.println(p);
        System.out.println(p.getClasse());
    }
}