package io;

public class Robotachenilles extends Robot {

  public Robotachenilles(int lig, int col, int vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(2000);
  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.getVitesse();
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
