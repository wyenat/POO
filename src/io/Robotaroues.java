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

      boolean test1 = (this.GetLigne() == incendie.GetLigne()+1)&&(this.GetColonne() == incendie.GetColonne());
      boolean test2 = (this.GetLigne() == incendie.GetLigne()) && (this.GetColonne() == incendie.GetColonne()-1);
      boolean test3 = (this.GetLigne() == incendie.GetLigne()) && (this.GetColonne() == incendie.GetColonne()+1);
      boolean test4 = (this.GetLigne() == incendie.GetLigne()-1) && (this.GetColonne() == incendie.GetColonne());

      return (test1 || test2 ||test3 || test4);
    }
    return false;
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


}
