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

  public int remplirReservoir(){
      return 2000;
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


  public long getDatevider(){
    return 8;
  }

  public int Vider(Simulateur simu, int ligne, int colonne){
    if (testVider(simu, ligne, colonne)){
      return 100;
    }
    return 0;
  }


  public boolean testVider(Simulateur simu, int lig, int col){
    Incendie[] incendies = simu.donnees.GetIncendies();
    boolean incendie_ici = false;
    Incendie incendie = incendies[0];
    for (int i=0; i<incendies.length; i++){
      if (incendies[i].GetLigne()==lig && incendies[i].GetColonne()==col){
        incendie_ici = true;
        incendie = incendies[i];

      }
    }
    if (incendie_ici){
      boolean test1 = (lig == this.GetLigne()+1)&&(this.GetColonne() == col);
      boolean test2 = (lig == this.GetLigne()) && (this.GetColonne() == col-1);
      boolean test3 = (lig == this.GetLigne()) && (this.GetColonne() == col+1);
      boolean test4 = (lig == this.GetLigne()-1) && (this.GetColonne() == col);
      return (test1 || test2 ||test3 || test4);

    }
    return false;
  }


  public boolean test_deplacement(Case C){
    boolean possible = true;
    switch (C.GetNature()){
      case EAU:
          possible = false;
          break;
      case ROCHE:
          possible = false;
          break;
      default:
          break;
    }
    return possible;
  }
}
