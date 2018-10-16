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

class Robotaroues extends Robot {

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

class Robotachenilles extends Robot {

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


class Robotapattes extends Robot {

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



class Robotdrone extends Robot {

  public Robotdrone(int lig, int col, int vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(10000);
  }


  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.getVitesse();
    return vitesse;
  }
}
