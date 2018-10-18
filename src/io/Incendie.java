package io;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import gui.GUISimulator;
import gui.Oval;
import gui.Simulable;
import gui.Text;

public class Incendie{
  /**
  Un incendie est défini par sa position et par son intensité (nb de litres d'eau
  nécessaires pour l'éteindre)
  */
  private int ligne;
  private int colonne;
  private int nb_litres_extinction;

  public Incendie(int lig, int col, int nbl){
    this.ligne = lig;
    this.colonne = col;
    this.nb_litres_extinction = nbl;
  }

  public int GetLigne(){
      return this.ligne;
  }

  public int GetColonne(){
      return this.colonne;
  }

  public int GetIntensite(){
      return this.nb_litres_extinction;
  }

  public void draw_incendie(GUISimulator gui, int taille_case){
      Color rouge = Color.decode("#e74c3c");
      Color orange = Color.decode("#f39c12");
      Color jaune = Color.decode("#f1c40f");

      gui.addGraphicalElement(
          new Oval(
              taille_case/2 + this.colonne*taille_case, //abscisse milieu
              taille_case/2 + this.ligne*taille_case, //ordonnee milieu
              rouge,
              rouge,
              (taille_case*9)/10 //diamètre
          )
      );
  }

}
