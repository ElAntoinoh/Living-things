import Metier.*;

import java.io.File;
import java.util.Scanner;

public class LivingThings {
    public static void main(String[] args) throws Exception {
        chargerFichiers(new String[] { "classes.txt", "equipements.txt", "monstres.txt", "personnages.txt" });

        for( Classe classe : Classe.listeClasses )
            System.out.println(classe);

        System.out.println("====================\n");

        for( Equipement equipement : Equipement.listeEquipements )
            System.out.println(equipement);
        
        System.out.println("====================\n");

        for( Monstre monstre : Monstre.listeMonstres )
            System.out.println(monstre);
        
        System.out.println("====================\n");

        for( Personnage personnage : Personnage.listePersonnages )
            System.out.println(personnage);
    }

    static void chargerFichiers(String[] tabFichiers) throws Exception {
        Scanner sc;

        for( String fichier : tabFichiers ) {
            sc = new Scanner(new File("../data/" + fichier));

            while(sc.hasNextLine()) {
                String[] arguments = sc.nextLine().split("\\|");

                switch(fichier) {
                    case "classes.txt":
                        new Classe(arguments[0], Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]));
                        break;
                    
                    case "equipements.txt":
                        new Equipement(arguments[0], arguments[1], Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]));
                        break;
                    
                    case "monstres.txt":
                        new Monstre(arguments[0], Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]));
                        break;
                    
                    case "personnages.txt":
                        for( Classe classe : Classe.listeClasses )
                            if( classe.getNom().equals(arguments[1]) )
                                new Personnage(arguments[0], classe);
                }
            }

            sc.close();
        }
    }
}