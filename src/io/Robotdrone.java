package io;
import io.*;


public class Robotdrone extends Robot{

  public Robotdrone(int lig, int col, double vitesse_deplacement){
    super(lig, col, vitesse_deplacement);
    super.setReservoir(10000);
    //Degueu mais je sais pas faire autrement
    TypeRobot T;
    String mmT = "DRONE";
    T = TypeRobot.valueOf(mmT);
    super.SetTypeRobot(T);
    //


  }

  public long getDateremplir(){
    return 30*60;
  }

  public boolean testRemplir(Simulateur simu, int lig, int col){
    if (super.GetLigne() == lig && super.GetColonne() == col){
        return true;
      }

    return false;
  }

  public int remplirReservoir(Simulateur simu, int lig, int col){
    if (testRemplir(simu, lig, col)){
      return 10000;
    }
    return 0;
  }

  public long getDatevider(){
    return 30;
  }


  public int vider(Simulateur simu, int ligne, int colonne, int intensite){
      if (testVider(simu, ligne, colonne)){
        if (intensite >= this.getReservoir()){

          return 10000;
        }
        else{

          return 10000-intensite;
        }
    }
    return 0;
  }

  public double GetVitesse(NatureTerrain Nature){
    double vitesse = super.GetVitesse();
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


      if (this.GetLigne() == incendie.GetLigne() && this.GetColonne() == incendie.GetColonne()){
        return true;
      }
    }
    return false;
  }

  public boolean test_deplacement(Case C){
    return true;
  }

}
