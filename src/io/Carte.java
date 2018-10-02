package io;

import java.io.Case;

public class Carte{
    /**
     * Contient les données de la carte
     */

     private int tailleCases;
     private int NbLignes;
     private int nbColonnes;
     private Case[] TableauDeCases;

     public Carte(int tailleC, int nbL, int nbC){
         /**
          * Crée une carte de taille nbL*nbC dont les cases sont de taille tailleC
          */
         this.SetTailleCases(tailleC);
         this.SetNbLignes(nbL);
         this.SetNbColonnes(nbC);

     }

     public void SetTailleCases(int taille){
         /* Définit la taille des cases.
          *Invariant de classe : taille > 0
          */
          if (taille =< 0){
              throw new IllegalArgumentException("Taille des cases nulle ou négative !");
          }
          this.tailleCases = taille;
     }

     public int GetTailleCases(){
         /**
          * Retourne la taille des cases
          */
          return this.tailleCases;
     }

     public void SetNbLignes(int taille){
         /* Définit le nombre de lignes.
          *Invariant de classe : NbLignes > 0
          */
          if (taille =< 0){
              throw new IllegalArgumentException("Nombre de lignes nul ou négatif !");
          }
          this.NbLignes = taille;
     }

     public int GetNbLignes(){
         /**
          * Retourne le nombre de lignes
          */
          return this.NbLignes;
     }

     public void SetNbColonnes(int taille){
         /* Définit le nombre de Colonnes.
          *Invariant de classe : NbColonnes > 0
          */
          if (taille =< 0){
              throw new IllegalArgumentException("Nombre de Colonnes nul ou négatif !");
          }
          this.NbColonnes = taille;
     }

     public int GetNbColonnes(){
         /**
          * Retourne le nombre de Colonnes
          */
          return this.NbColonnes;
     }

     public int voisinExiste(Case C,){


     }


 }
