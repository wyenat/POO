package io;

import io.TypeRobot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import gui.Text;

public abstract class Robot {
  private int ligne;
  private int colonne;
  private double vitesse_deplacement;
  private int reservoir;
  private TypeRobot type;

  public Robot(int lig, int col, double vitesse_deplacement){
    this.ligne = lig;
    this.colonne = col;
    this.vitesse_deplacement = vitesse_deplacement;
    this.reservoir = 0; //Absurde car c'est pas lui qui remplit
  }

    public int GetLigne(){
        return this.ligne;
    }

    public int GetColonne(){
        return this.colonne;
    }

    private void setLigne(int ligne){
        this.ligne = ligne;
    }

    private void setColonne(int colonne){
        this.colonne = colonne;
    }

    public double getVitesse(){
      return this.vitesse_deplacement;
    }

    public int getReservoir(){
      return this.reservoir;
    }
    public void setReservoir(int reservoir){
      this.reservoir = reservoir;
    }

    public void setPosition(Case Case){
      this.setLigne(Case.GetLigne());
      this.setColonne(Case.GetColonne());
    }

    public TypeRobot GetTypeRobot(){
      return this.type;
    }

    private void draw_robot(GUISimulator gui, int taille_case){

      /*A FINIR*/
      switch (this.GetTypeRobot()){
          case DRONE:
              break;
          case ROUES:
              break;
          case CHENILLES:
              break;
          case PATTES:
              break;
      }
    }

}
