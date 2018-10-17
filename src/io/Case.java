package io;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import gui.Text;


public class Case {
  private int ligne;
  private int colonne;
  private NatureTerrain nature;

  public Case(int l, int c, NatureTerrain n){
    /**
    Constructeur de la case
    */
    this.ligne = l;
    this.colonne = c;
    this.nature = n;
  }

  public int GetLigne(){
    return this.ligne;
  }

  public int GetColonne(){
    return this.colonne;
  }

  public NatureTerrain GetNature(){
      /**
       * Retourne la nature de la case
       */
       return this.nature;
  }

  public void draw_case(GUISimulator gui, int taille_case){
      Color bords = Color.decode("#000000");

      String color_fond = "#ffffff";
      switch (this.GetNature()){
          case EAU:
              color_fond = "#a0edff"; break;
          case FORET:
              color_fond = "#87ff70"; break;
          case ROCHE:
              color_fond = "#808080"; break;
          case HABITAT:
              color_fond = 	"#ff9ec6"; break;
      }
      Color fond = Color.decode(color_fond);

      gui.addGraphicalElement(
        new Rectangle(
            taille_case/2 + this.colonne*taille_case, //abcisse du milieu de la case
            taille_case/2 + this.ligne*taille_case, //ordonnee du milieu de la case
            bords, //couleur des contours
            fond, //Couleur du fond
            taille_case, //largeur
            taille_case //longueur
        )
      );
  }
}
