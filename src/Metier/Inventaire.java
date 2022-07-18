package Metier;

public class Inventaire {
    private Equipement[] inventaireEquipements;
    private Equipement[] tenue;

    private static String[] tabEmplacements = {
        "tete",
        "torse",
        "jambes",
        "mains",
        "pieds",
        "arme"
    };

    public Inventaire() {
        this.inventaireEquipements = new Equipement[20];
        this.tenue                 = new Equipement[6];
    }

    public void recupererEquipement(Equipement equipement) {
        if( Utils.estPlein(this.inventaireEquipements) ) {
            System.out.println("Récupération de l'équipement impossible. Inventaire plein");
            return;
        }

        this.inventaireEquipements[Utils.premierEmplacement(this.inventaireEquipements)] = equipement;
    }

    public void jeterEquipement(int indice) {
        Utils.retirerObjet(this.inventaireEquipements, indice);
    }

    public void equiper(int indice) {
        Equipement equipement = this.inventaireEquipements[indice];

        for( int i = 0; i < Inventaire.tabEmplacements.length; i++ )
            if( equipement.getType().equals(Inventaire.tabEmplacements[i]) ) {
                Equipement tmp = this.tenue[i];

                this.tenue[i] = equipement;

                this.inventaireEquipements[indice] = tmp;
            }
    }

    public void desequiper(int indice) {
        if( Utils.estPlein(this.inventaireEquipements) ) {
            System.out.println("Déséquipement de l'équipement impossible. Inventaire plein");
            return;
        }
        
        this.inventaireEquipements[Utils.premierEmplacement(this.inventaireEquipements)] = this.tenue[indice];

        this.tenue[indice] = null;
    }

    //#region Accesseurs
    public Equipement[] getTenue() { return this.tenue; }

    public Equipement getTete  () { return this.tenue[0]; }
    public Equipement getTorse () { return this.tenue[1]; }
    public Equipement getJambes() { return this.tenue[2]; }
    public Equipement getMains () { return this.tenue[3]; }
    public Equipement getPieds () { return this.tenue[4]; }
    public Equipement getArme  () { return this.tenue[5]; }

    public Equipement[] getInventaireEquipements() { return this.inventaireEquipements; }
    //#endregion
}
