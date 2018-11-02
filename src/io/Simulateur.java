package io;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Math;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import gui.Text;

public class Simulateur implements Simulable {

    public DonneesSimulation donnees;
    
    public int pas;
    public int time;

    public Evenement[] Evenements = new Evenement[1000];
    public int nb_evenements;

    public GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);

    public Simulateur(DonneesSimulation data) {
        gui.setSimulable(this);				// association a la gui!

        /*Lecture des données de simulation */
        this.donnees = data;
        this.time = 0;
        this.pas = 20; //Pour l'instant je le set à 20.
        this.nb_evenements = 0;
        draw();
    }
    
    public void executeEvenements(){
        /** Trouve dans la liste des évènements ceux dont la date est passée, 
         * et les execute
         */
         for (int i=0; i<nb_evenements; i++){
             if (this.Evenements[0].getDate() <= this.time){
                this.Evenements[0].execute();
             }
         }
    }
    
    public void addEvenement(Evenement e){
        /** 
         * Ajoute un évènement
         */
         this.Evenements[nb_evenements] = e;
         this.nb_evenements++;
    }
    
    
    @Override
    public void next() {
      /** 
       * Avance la simulation d'un pas de temps
       */
      this.time += this.pas;
      executeEvenements();
      draw();
      System.out.println("time = " + this.time);
    }

    @Override
    public void restart(){
      /**
       * Replace la simulation dans les conditions initiales 
       */
      this.time = 0;
      try{
          this.donnees = LecteurDonnees.lire(this.donnees.fichier);
          draw();
      }
      catch (FileNotFoundException e) {
          System.out.println("fichier " + this.donnees.fichier+ " inconnu ou illisible");
      } catch (DataFormatException e) {
          System.out.println("\n\t**format du fichier " +this.donnees.fichier+ " invalide: " + e.getMessage());
      }
    }


    public void draw(){
      // gui.reset();

      Carte cart = this.donnees.GetCarte();
      int nb_lignes = cart.GetNbLignes();
      int nb_colonnes = cart.GetNbColonnes();

      /*La valeur taille_cases dans Cartes sert à quoi ?? J'ai choisi
      d'adapter la taille des cases à ce qu'on peut bien voir à l'écran
      en fonction du nb de lignes et de colonnes*/
      //int taille_theorique cases = cart.GetTailleCases();

      int taille_ecran = 500;
      int taille_cases = taille_ecran/Math.max(nb_colonnes, nb_lignes);

      // System.out.println("LIGNE = " + nb_lignes + "\nColonne = " + nb_colonnes);
      // System.out.println("Taille des cases = " + taille_cases);

      for (Case c : cart.GetTableauDeCases()){
          c.draw_case(this.gui, taille_cases);
      }

      for (Incendie i : this.donnees.GetIncendies()){
        i.draw_incendie(this.gui, taille_cases);
      }

      for (Robot r : this.donnees.GetRobots()){
        r.draw_robot(this.gui, taille_cases);
      }
    }
}
