
package io;

// import java.io.Carte;
import java.io.Carte;

public class Robot{

    /* Attributs communs à tous les robots et fonctions associées*/
    private Case position;
    private int vitesse;
    private int litres_en_reserve;

    public Case getPosition(){
      /* Renvoie la case sur laquelle est le robot*/
      return this.position;
    }

}
