package Metier;

public record Utils() {
    public static void retirerObjet(Object[] tab, int indice) {
        tab[indice] = null;
    }

    public static boolean estPlein(Object[] tab) {
        for( Object object : tab )
            if( object == null ) return false;
        
        return true;
    }

    public static int premierEmplacement(Object[] tab) {
        for( int i = 0; i < tab.length; i++ ) 
            if( tab[i] == null ) return i;
        
        return -1;
    }
}
