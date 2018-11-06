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


  public long getDateremplir(){
    throw new IllegalArgumentException("On ne peut pas remplir le reservoir d'un robot à pattes");
  }



  public long getDatevider(){
    return 1;
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
      boolean test = (lig == this.GetLigne()) && (this.GetColonne() == col);
      return test;

    }
    return false;

  }

  public int vider(Simulateur simu, int ligne, int colonne, int intensite){
    if (testVider(simu, ligne, colonne)){
      return intensite;
    }
    return 0;
  }



  public boolean test_deplacement(Case C){
    boolean possible = true;
    switch (C.GetNature()){
      case EAU:
        possible = false;
        throw new IllegalArgumentException("Le robot ne peut pas aller là");
      default:
          break;
    }
    return possible;
  }

}
