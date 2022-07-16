package Metier;

/**
 * La classe Vivant est héritée par toutes les classes gérant des êtres vivants, hostiles comme pacifiques.
 * Elle hérite de la classe Statistics
 */
public class Vivant extends Statistics {
    protected int pvMax;
    protected int pmMax;

    //#region Accesseurs
    public int    getPvMax() { return this.pv; }
    public int    getPmMax() { return this.pm; }
    //#endregion
}