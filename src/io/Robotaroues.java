package io;


public class Robotaroues extends Robot {

  public Robotaroues(int lig, int col, double vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(5000);
    //Degueu mais je sais pas faire autrement
    TypeRobot T;
    String mmT = "ROUES";
    T = TypeRobot.valueOf(mmT);
    super.SetTypeRobot(T);
    //

  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.GetVitesse();
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
