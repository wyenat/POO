package io;
import gui.*;
import java.awt.*;

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

    public void setLigne(int ligne){
        this.ligne = ligne;
    }

    public void setColonne(int colonne){
        this.colonne = colonne;
    }

    public double GetVitesse(){
      return this.vitesse_deplacement;
    }

    public int getReservoir(){
      return this.reservoir;
    }
    public void setReservoir(int reservoir){
      this.reservoir = reservoir;
    }

    public void setVitesse(double vitesse){
        this.vitesse_deplacement = vitesse;
    }

    public void setPosition(Case Case){
      this.setLigne(Case.GetLigne());
      this.setColonne(Case.GetColonne());
      switch (this.GetTypeRobot()) {
        case ROUES:
          Robotaroues Robot_roue = new Robotaroues(this.GetLigne(), this.GetColonne(), this.GetVitesse());
          Robot_roue.setVitesse(Robot_roue.GetVitesse());
          break;

        case CHENILLES:
          Robotachenilles Robot_chenille = new Robotachenilles(this.GetLigne(), this.GetColonne(), this.GetVitesse());
          Robot_chenille.setVitesse(Robot_chenille.GetVitesse());
          break;

        case PATTES:
          Robotapattes Robot_pattes = new Robotapattes(this.GetLigne(), this.GetColonne(), this.GetVitesse());
          Robot_pattes.setVitesse(Robot_pattes.GetVitesse());
          break;

        case DRONE:
          Robotdrone Robot_drone = new Robotdrone(this.GetLigne(), this.GetColonne(), this.GetVitesse());
          Robot_drone.setVitesse(Robot_drone.GetVitesse());
          break;

        default:
          System.out.println("AIE");
          break;

      }
    }

    public TypeRobot GetTypeRobot(){
      return this.type;
    }

    public void SetTypeRobot(TypeRobot T){
      this.type = T;
    }

    public void draw_robot(GUISimulator gui, int taille_case){
      int x = taille_case/5 + (this.GetLigne())* taille_case;
      int y =  taille_case/5 + (this.GetColonne())* taille_case;
      int taille = 4 * taille_case/5;

      /*A FINIR*/
      switch (this.GetTypeRobot()){
          case DRONE:
              gui.addGraphicalElement(new ImageElement(y, x, "drone.jpg", taille, taille, new Canvas()));
              break;
          case ROUES:
              gui.addGraphicalElement(new ImageElement(y, x, "roues.jpg", taille, taille, new Canvas()));
              break;
          case CHENILLES:
              gui.addGraphicalElement(new ImageElement(y, x, "chenilles.png", taille, taille, new Canvas()));
              break;
          case PATTES:
              gui.addGraphicalElement(new ImageElement(y, x, "pattes.jpg", taille, taille, new Canvas()));
              break;
      }
    }

    @Override
    public String toString(){
        return "Type : " +  this.GetTypeRobot().toString() + ", Case = (" + this.GetLigne() + ", " + this.GetColonne() + ")";
    }

}
