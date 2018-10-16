package io;

public class Robot {
  private int ligne;
  private int colonne;
  private double vitesse_deplacement;
  private int Reservoir;

  public Robot(int lig, int col, double vitesse_deplacement){
    this.ligne = lig;
    this.colonne = col;
    this.vitesse_deplacement = vitesse_deplacement;
    this.Reservoir = -1; //Absurde car c'est pas lui qui rempli

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
      return this.Reservoir;
    }
    public void setReservoir(int reservoir){
      this.Reservoir = reservoir;
    }

    public void setPosition(Case Case){
      this.setLigne(Case.GetLigne());
      this.setColonne(Case.GetColonne());
    }

}
