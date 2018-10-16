package io;

public class Carte{
    /**
     * Contient les données de la carte
     */

     private int taille_cases;
     private int nb_lignes;
     private int nb_colonnes;
     private Case[] tableau_de_cases;

     public Carte(int taille_cases, int nb_lignes, int nb_colonnes, Case[] tableau_de_cases){
       /**
       Crée une carte de taille nb_lignes*nb_colonnes dont les cases sont de
       taille taille_cases
       */
       this.SetTailleCases(taille_cases);
       this.SetNbLignes(nb_lignes);
       this.SetNbColonnes(nb_colonnes);
       this.SetTableauDeCases(tableau_de_cases);
     }

     public void SetTableauDeCases(Case[] tab){
         /**
          * Définit toutes les case
          * Invariant de classes : len(tableau) == nbLignes * nbColonnes
          */
          if (tab.length != this.GetNbLignes() * this.GetNbColonnes() ){
              throw new IllegalArgumentException("Nombre de cases non conforme !");
          }
          this.tableau_de_cases = tab;
     }

     public Case[] GetTableauDeCases(){
       return this.tableau_de_cases;
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

     public int GetTailleCases(){
         /**
          * returns the value of TailleCases
          */
          return this.taille_cases;
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

     public int GetNbLignes(){
         /**
          * returns the value off NbLignes
          */
          return this.nb_lignes;
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

     public int GetNbColonnes(){
         /**
          * returns the value of NbColonnes
          */
          return this.nb_colonnes;
      }
      public String ToString(){
         String returned_string =  "Taille des cases : " + this.GetTailleCases() + "\n" + "Dimensions : " + this.GetNbLignes() + " * " + this.GetNbColonnes();
         for (int lig=0; lig < this.GetNbLignes(); lig++){
             for (int col=0; col < this.GetNbColonnes(); col++){
                 returned_string += "\n Case(" + lig + "," + col + "): " + this.tableau_de_cases[lig*this.GetNbColonnes()+col].GetNature();
             }
         }
         return returned_string;
     }

}
