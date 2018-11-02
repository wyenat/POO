package io;

import io.LecteurDonnees;
import io.Case;

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

class Simulateur implements Simulable {

    public DonneesSimulation donnees;

    public Evenement[] Evenements = new Evenement[1000];

    public GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);

    public Simulateur(DonneesSimulation data) {
        gui.setSimulable(this);				// association a la gui!

        /*Lecture des données de simulation */
        this.donnees = data;
        draw();
    }

    @Override
    public void next() {
      //A FAIRE
    }

    @Override
    public void restart() {
      //A FAIRE
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

      System.out.println("LIGNE = " + nb_lignes + "\nColonne = " + nb_colonnes);
      System.out.println("Taille des cases = " + taille_cases);

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
