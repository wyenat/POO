package io;


public class Evenementdeplacement extends Evenement {
  private Robot Robot;
  private Case Case;

  public Evenementdeplacement(long Datefin, Robot Robot, Case Case){
    super(Datefin);
    this.Robot = Robot;
    this.Case = Case;
  }

  public void execute(){
    Robot.setPosition(Case);
  }
}
