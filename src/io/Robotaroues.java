package io;


public class Robotaroues extends Robot {

  public Robotaroues(int lig, int col, int vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(5000);
  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.getVitesse();
    switch (Nature){
        case TERRAIN_LIBRE:
          break;

        case HABITAT:
          break;

        default:
          vitesse = 0;
          break;
    }
    return vitesse;

  }


}
