
package io;

// import java.io.Carte;
import java.io.Carte;

public class Incendie{
    /**
     * Contient les données d'un incendie:
        -position
        -force
     */
     private int ligne;
     private int colonne;
     private int intensite;

     public int GetLigne(){
       /* Permet la recupération de la ligne*/
       return this.ligne;
     }

     public int SetLigne(int lig){
       /* Permet l'affectation de la ligne
          N'a pour l'instant pas de test */
        this.ligne = lig;
     }


     public int GetColonne(){
       /* Permet la recupération de la colonne*/
       return this.colonne;
     }

     public int SetLigne(int col){
       /* Permet l'affectation de la colonne
          N'a pour l'instant pas de test */
        this.col = col;
     }

     public int GetIntensite(){
       /* Permet la recupération de l'intensité*/
       return this.intensite;
     }

     public int SetLigne(int intensite){
       /* Permet l'affectation de l'intensite
          N'a pour l'instant qu'un test simple */
        if (intensite > 0){
          this.intensite = intensite;
        }
        else{
          throw new IllegalArgumentException("Une intensité ne peut être negative");
        }

     }
}
