package io;
import java.io.*;

public abstract class Evenement{
  protected Robot robot;
  private long Datefin;
  private Simulateur simu;
  // private Evenement[] Events;
  // public int nombre_evenements;


public Evenement(Robot robot, Simulateur simulation, long Datefin){
    this.simu = simulation;
    this.robot = robot;
    this.setDate(Datefin);
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


  private void setDate(long Date){
    long dateMax = 0;
    System.out.println("#### ON RENTRE DANS LE SET ####");
    System.out.println("Robot de this : " + this.robot);
    for (int evenement=0; evenement < simu.nb_evenements; evenement++){
        // System.out.println("Robot de this : " + this.getRobot() + "\n Simu " + simu.Evenements[evenement].getRobot());
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
  }

  public long getDate(){
    return this.Datefin;
  }

  @Override
  public String toString(){
      return "Evenement : date de fin = " + this.getDate() + ", de type : ";
  }

}
