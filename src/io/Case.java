package io;

// import java.io.Carte;
import java.io.NatureTerrain;

public class Case{
    /**
     * Contient les données d'une case
     * On rajouter les invariants de classe :
     * 0 < ligne < NbLignes et 0 < colonne < nbColonnes
     */
     private int ligne;
     private int colonne;
     private NatureTerrain nature;

     public int GetLigne(){
         /**
          * Retourne la ligne de la case
          */
         return this.ligne;
     }

     public int GetColonne(){
        /*
         * Retourne la colonne de la case
         */
         return this.colonne;
     }

     public enum NatureTerrain GetNature{
         /**
          *  Retourne la nature de la cases
          */
          return this.nature;
     }
}
