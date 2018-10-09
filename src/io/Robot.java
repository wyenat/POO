package io;

public class Robot {
  private TypeRobot type;
  private int ligne;
  private int colonne;
  private int vitesse_deplacement;

  public Robot(TypeRobot type, int lig, int col, int vitesse_deplacement){
    this.type = type;
    this.ligne = lig;
    this.colonne = col;
    this.vitesse_deplacement = vitesse_deplacement;
  }

    public int GetLigne(){
        return this.ligne;
    }

    public int GetColonne(){
        return this.colonne;
    }

    public TypeRobot GetType(){
        return this.type;
    }

    public int GetVitesse(){
        return this.vitesse_deplacement;
    }
}
