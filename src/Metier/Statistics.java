package Metier;

public class Statistics {
    protected String nom;

    protected int pv;
    protected int pm;

    protected int attaque;
    protected int attaqueMagique;

    protected int defense;
    protected int defenseMagique;

    public String getNom           () { return this.nom;            }
    public int    getPv            () { return this.pv;             }
    public int    getPm            () { return this.pm;             }
    public int    getAttaque       () { return this.attaque;        }
    public int    getAttaqueMagique() { return this.attaqueMagique; }
    public int    getDefense       () { return this.defense;        }
    public int    getDefenseMagique() { return this.defenseMagique; }
}