import java.util.ArrayList;
import java.util.HashMap;

public class Personnage extends Vivant {
    static ArrayList<Personnage> listePersonnages = new ArrayList<>();

    private HashMap<Classe, Integer> listeClasses;
    private Classe classe;
    private int niveau;

    private int pvBruts;
    private int pmBruts;

    private int attaqueBrute;
    private int attaqueMagiqueBrute;

    private int defenseBrute;
    private int defenseMagiqueBrute;

    public Personnage(String nom, Classe classe) {
        this.nom = nom;

        this.listeClasses = new HashMap<>();
        this.listeClasses.put(this.classe = classe, this.niveau = 1);

        this.pv = this.pvMax = this.pvBruts = 10;
        this.pm = this.pmMax = this.pmBruts = 5;

        this.attaque        = this.attaqueBrute        = 4;
        this.attaqueMagique = this.attaqueMagiqueBrute = 2;

        this.defense        = this.defenseBrute        = 4;
        this.defenseMagique = this.defenseMagiqueBrute = 2;

        Personnage.listePersonnages.add(this);
    }

    public void monterDeNiveau() {
        listeClasses.replace(classe, this.niveau++, this.niveau);

        recalculerStatistiques();

        this.pv += this.classe.getPv();
        this.pm += this.classe.getPm();
    }

    private void recalculerStatistiques() {
        this.pvMax = this.pvBruts + this.niveau * this.classe.getPv();
        this.pmMax = this.pmBruts + this.niveau * this.classe.getPm();

        this.attaque        = this.attaqueBrute        + this.niveau * this.classe.getAttaque();
        this.attaqueMagique = this.attaqueMagiqueBrute + this.niveau * this.classe.getAttaqueMagique();

        this.defense        = this.defenseBrute        + this.niveau * this.classe.getDefense();
        this.defenseMagique = this.defenseMagiqueBrute + this.niveau * this.classe.getDefenseMagique();

        if( this.pv > this.pvMax ) this.pv = this.pvMax;
        if( this.pm > this.pmMax ) this.pm = this.pmMax;
    }

    public void changerDeClasse(Classe newClasse) {
        System.out.println(this.listeClasses.get(this.classe));

        this.classe = newClasse;

        if( this.listeClasses.containsKey(newClasse) )
            this.niveau = this.listeClasses.get(newClasse);
        else
            listeClasses.put(newClasse, this.niveau = 1);

        recalculerStatistiques();
    }

    // Accesseurs
    public int                      getNiveau () { return this.niveau;       }
    public HashMap<Classe, Integer> getClasses() { return this.listeClasses; }
    public Classe                   getClasse () { return this.classe;       }
    public int                      getPvBruts() { return this.pvBruts;      }
    public int                      getPmBruts() { return this.pmBruts;      }

    public String toString() {
        return String.format("%s (%s niveau %d)\n", this.nom.toUpperCase(), this.classe.getNom(), this.niveau) +
            String.format("  pv: %9s | pm:         %9s\n", this.pv + "/" + this.pvMax, this.pm + "/" + this.pmMax) +
            String.format("  attaque: %4d | attaque magique: %4d\n", this.attaque, this.attaqueMagique) +
            String.format("  defense: %4d | defense magique: %4d\n", this.defense, this.defenseMagique);
    }
}