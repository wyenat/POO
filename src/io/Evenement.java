package io;
import java.io.*;

public abstract class Evenement{
  protected Robot robot;
  private long Datefin;
  private Simulateur simu;
  private TypeEvenement typeEvenement;


public Evenement(Robot robot, Simulateur simulation, long Datefin, TypeEvenement type){
    this.simu = simulation;
    this.robot = robot;
    this.setDate(Datefin);
    this.robot.setEtat(Etat.OCCUPE);
    this.typeEvenement = type;
    // this.Events = new void[1000];
    // this.nombre_evenements = 0;
    // this.getSimu().addEvenement(this);
  }
public Simulateur getSimu(){
    return this.simu;
}

public void setSimu(Simulateur simulateur){
    this.simu = simulateur;
}


public Robot getRobot(){
     return this.robot;
  }


  public void setDate(long Date){
    long dateMax = 0;
    for (int evenement=0; evenement < simu.nb_evenements; evenement++){
        if ( this.getRobot() == simu.Evenements[evenement].getRobot()){
            if ( dateMax < simu.Evenements[evenement].getDate()){
              dateMax = simu.Evenements[evenement].getDate();
            }
        }
    }
    this.Datefin = Date + dateMax;
  }

  public void execute(){
      /**
       * Ne fait absolument rien ptdr
       */
       long dateMax = 0;
       for (int evenement=0; evenement < simu.nb_evenements; evenement++){
           if ( this.getRobot() == simu.Evenements[evenement].getRobot()){
               if ( dateMax < simu.Evenements[evenement].getDate()){
                 dateMax = simu.Evenements[evenement].getDate();
               }
           }
       }
    //    System.out.println("Date: " + dateMax + "temps : " + this.simu.time);
       if (dateMax <= this.simu.time + this.simu.pas){
          this.getRobot().setEtat(Etat.LIBRE);
       }

  }


  public long getDate(){
    return this.Datefin;
  }

  public TypeEvenement getTypeEvenement(){
      return this.typeEvenement;
  }

  public void setTypeEvenement(TypeEvenement type){
      this.typeEvenement = type;
  }

  @Override
  public String toString(){
      return "Evenement : date de fin = " + this.getDate() + ", de type : ";
  }

}
