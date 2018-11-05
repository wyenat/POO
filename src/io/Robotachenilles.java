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
          break;()
    }
    return possible;
  }

  public int Vider(){
    if (testVider(this.GetLigne(), this.GetColonne()){
        return 100;
    }
  }

  public int testVider(int lig, int col ){
    boolean test1 = (lig == this.GetLigne()+1)&&(this.GetColonne() == col);
    boolean test2 = (lig == this.GetLigne()) && (this.GetColonne() == col-1);
    boolean test3 = (lig == this.GetLigne()) && (this.GetColonne() == col+1);
    boolean test4 = (lig == this.GetLigne()-1) && (this.GetColonne() == col);
    return (test1 || test2 ||test3 || test4);
  }
}
