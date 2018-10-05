/**
Fichier à modifier pour faire l'affichage !
On veut crééer une classe qui réalise l'interface Simulable
(Simulateur implements Simulable)
*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import gui.Text;

public class TestSimulateur {
    public static void main(String[] args) {
        // crée la fenêtre graphique dans laquelle dessiner
        GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
        // crée l'invader, en l'associant à la fenêtre graphique précédente
        Simulateur simulateur = new Simulateur(gui, Color.decode("#f2ff28"));
    }
}

class Simulateur implements Simulable {
    /** L'interface graphique associée */
    private GUISimulator gui;

    /** La couleur de dessin du simulateur */
    private Color simulateurColor;


    public Simulateur(GUISimulator gui, Color simulateurColor) {
        this.gui = gui;
        gui.setSimulable(this);				// association a la gui!
        this.simulateurColor = simulateurColor;

        draw();
    }

    @Override
    public void next() {
        draw();
    }

    @Override
    public void restart() {
        draw();
    }

    /**
     Lance le simulateur
     C'est cette fonction qui va réellement dessiner la carte
     */
    private void draw() {
        gui.reset();	//clear the window
    }
}
