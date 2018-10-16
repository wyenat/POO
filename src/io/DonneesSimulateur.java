package io;

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
    /** L'interface graphique associée */
    private GUISimulator gui;

    /** La couleur de dessin du simulateur */
    private Color simulateurColor;


    public Simulateur(GUISimulator gui, Color simulateurColor) {
        this.gui = gui;
        gui.setSimulable(this);				// association a la gui!
        this.simulateurColor = simulateurColor;
    }

    @Override
    public void next() {
      //A FAIRE
    }

    @Override
    public void restart() {
      //A FAIRE
    }
}

public class DonneesSimulateur{

    private Carte carte;
    private Incendie[] incendies;
    private Robot[] robots;

    // crée la fenêtre graphique dans laquelle dessiner
    private static GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
    // crée le simulateur, en l'associant à la fenêtre graphique précédente
    private static Simulateur simulateur = new Simulateur(gui, Color.decode("#f2ff28"));

    public DonneesSimulateur(Carte c, Incendie i[], Robot r[]){
        /**
         * Constucteur de DonneesSimulation
         */
         this.SetCarte(c);
         this.SetIncendies(i);
         this.SetRobot(r);
     }

     public void SetCarte(Carte c){
         this.carte =c ;
     }

     public void SetIncendies(Incendie i[]){
         this.incendies = i;
     }

     public void SetRobot(Robot r[]){
         this.robots = r;
     }

     public Carte GetCarte(){
         return this.carte;
     }

     public Incendie[] GetIncendies(){
         return this.incendies;
     }

     public Robot[] GetRobots(){
         return this.robots;
     }

    private void AfficherIncendies(Incendie[] incendies){
        /**
         * Affiche les incendies
         */

    }

    private void AfficherRobots(Robot[] robots){
        /**
         * Affiche les robots
         */

    }

    public void afficher(){
        gui.reset();
    }
}
