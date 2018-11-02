package io;

public class Robotapattes extends Robot {

  public Robotapattes(int lig, int col, double vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(666); //POUDRE DONC INFINI
    //Degueu mais je sais pas faire autrement
    TypeRobot T;
    String mmT = "PATTES";
    T = TypeRobot.valueOf(mmT);
    super.SetTypeRobot(T);
    //


  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.GetVitesse();
    switch (Nature){
        case ROCHE:
          vitesse-=10;
          break;

        case EAU:
          vitesse = 0;
          break;

        default:
          break;
    }
    return vitesse;
  }
}
