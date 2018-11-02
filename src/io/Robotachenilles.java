package io;

public class Robotachenilles extends Robot {

  public Robotachenilles(int lig, int col, double vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(2000);
    //Degueu mais je sais pas faire autrement
    TypeRobot T;
    String mmT = "CHENILLES";
    T = TypeRobot.valueOf(mmT);
    super.SetTypeRobot(T);
    //
  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.GetVitesse();
    switch (Nature){
        case FORET:
          vitesse-=10;
          break;

        case EAU:
          vitesse = 0;
          break;

        case ROCHE:
          vitesse = 0;
          break;

        default:
          break;
    }

    return vitesse;
  }

  
}
