package io;

public class Robotapattes extends Robot {

  public Robotapattes(int lig, int col, int vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(666); //POUDRE DONC INFINI
  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.getVitesse();
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
