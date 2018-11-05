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

  public long getDatevider(){
    return 5;
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


  public int remplirReservoir(){
      return 5000;
  }

  public int Vider(){
    if (testVider(this.GetLigne(), this.GetColonne()){
        return 100;
    }
  }


  public boolean test_deplacement(Case C){
    boolean possible = false;
    switch (C.GetNature()){
      case TERRAIN_LIBRE:
          possible = true;
          break;
      case HABITAT:
          possible = true;
          break;
      default:
          break;
    }
    return possible;
  }

  public int testVider(Incendie incendie){
    boolean test1 = (this.GetLigne() == incendie.GetLigne()+1)&&(this.GetColonne() == incendie.GetColonne());
    boolean test2 = (this.GetLigne() == incendie.GetLigne()) && (this.GetColonne() == incendie.GetColonne()-1);
    boolean test3 = (this.GetLigne() == incendie.GetLigne()) && (this.GetColonne() == incendie.GetColonne()+1);
    boolean test4 = (this.GetLigne() == incendie.GetLigne()-1) && (this.GetColonne() == incendie.GetColonne());

    if (test1 || test2 ||test3 || test4){
      return 1;
    }
    return 0;
  }


}
