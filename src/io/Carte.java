package io;

public class Carte{
    /**
     * Contient les données de la carte
     */

     private int taille_cases;
     private int nb_lignes;
     private int nb_colonnes;
     private Case[] tableau_de_cases;

     public Carte(int taille_cases, int nb_lignes, int nb_colonnes){
       /**
       Crée une carte de taille nb_lignes*nb_colonnes dont les cases sont de
       taille taille_cases
       */
       this.SetTailleCases(taille_cases);
       this.SetNbLignes(nb_lignes);
       this.SetNbColonnes(nb_colonnes);
     }

     public void SetTailleCases(int taille){
         /* Définit la taille des cases.
         Invariant de classe : taille > 0
         */
         if (taille <= 0){
           throw new IllegalArgumentException("Taille des cases nulle ou négative !");
         }
         this.taille_cases = taille;
     }


     public void SetNbLignes(int nbl){
         /* Définit le nombre de lignes.
         Invariant de classe : NbLignes > 0
         */
         if (nbl <= 0){
           throw new IllegalArgumentException("Nombre de lignes nul ou négatif !");
         }
         this.nb_lignes = nbl;
     }


     public void SetNbColonnes(int nbc){
         /* Définit le nombre de Colonnes.
         Invariant de classe : NbColonnes > 0
         */
         if (nbc <= 0){
           throw new IllegalArgumentException("Nombre de Colonnes nul ou négatif !");
         }
         this.nb_colonnes = nbc;
     }

}
