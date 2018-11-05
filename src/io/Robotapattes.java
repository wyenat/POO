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

  public long getDatevider(){
    return 1;
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

      boolean test1 = (this.GetLigne() == incendie.GetLigne()+1)&&(this.GetColonne() == incendie.GetColonne());
      boolean test2 = (this.GetLigne() == incendie.GetLigne()) && (this.GetColonne() == incendie.GetColonne()-1);
      boolean test3 = (this.GetLigne() == incendie.GetLigne()) && (this.GetColonne() == incendie.GetColonne()+1);
      boolean test4 = (this.GetLigne() == incendie.GetLigne()-1) && (this.GetColonne() == incendie.GetColonne());
      return (test1 || test2 ||test3 || test4);

    }
    return false;
  }

  public int Vider(Simulateur simu, int ligne, int colonne){
    if (testVider(simu, ligne, colonne)){
        return 10;
    }
    return 0;
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

}
