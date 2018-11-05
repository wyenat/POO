package io;
import java.io.*;

public abstract class Evenement{
  private long Datefin;
  // private Evenement[] Events;
  // public int nombre_evenements;

  public Evenement(long Datefin){
    this.setDate(Datefin);
    // this.Events = new void[1000];
    // this.nombre_evenements = 0;
  }

  private void setDate(long Date){
    this.Datefin = Date;
  }

  public long getDate(){
    return this.Datefin;
  }

  public void execute(){
    //A FAIRE
  }

  @Override
  public String toString(){
      return "Evenement : date de fin = " + this.getDate() + ", de type : ";
  }

}
