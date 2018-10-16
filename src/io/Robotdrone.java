package io;


public class Robotdrone extends Robot{

  public Robotdrone(int lig, int col, int vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(10000);
  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.getVitesse();
    return vitesse;
  }
}
