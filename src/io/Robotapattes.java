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


  public int remplirReservoir(){
      return -1;
  }


  public boolean test_deplacement(Case C){
    boolean possible = true;
    switch (C.GetNature()){
      case EAU:
        possible = false;
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
