package io;

import io.LecteurDonnees;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import gui.Text;

class Simulateur implements Simulable {

    /** La couleur de dessin du simulateur */
    public Color simulateurColor = Color.decode("#f2ff28");

    public DonneesSimulation donnees;

    private GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);

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
      /** Bon, alors j'ai rien écrit d'autre, c'était juste pour m'assurer que ya pas des problèmes de compilation de merde
       * avec le make.
       * J'ai mis des chiffres au pif, fais ton truc. Il accède correctement à DonneesSimulation, les valeurs
       * sont celles rentrées. Tout est private, s'il te manque un GetX, écris le.
       * Note : pas besoin de static pour ce draw pour l'instant. :)
       * Autre note : pas besoin de copier-coller ce code dans un Simulation.java et de ne travailler que là-bas, tout marche :)
       */
      int ligne = this.donnees.GetCarte().GetTableauDeCases()[6].GetLigne();
      int col = this.donnees.GetCarte().GetTableauDeCases()[6].GetColonne();
      System.out.println("LIGNE = " + ligne + "\nColonne = " + col);
      gui.addGraphicalElement(new Rectangle(30*col, 30*ligne, this.simulateurColor, this.simulateurColor, 100, 100));
    }
}
