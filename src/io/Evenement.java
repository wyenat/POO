package io;
import java.io.*;

public abstract class Evenement{
  private long Datefin;

  public Evenement(long Datefin){
    this.setDate(Datefin);
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

}
