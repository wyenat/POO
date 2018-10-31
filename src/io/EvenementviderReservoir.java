
package io;



public class EvenementviderReservoir extends Evenement {
  private Robot Robot;

  public EvenementviderReservoir(long Datefin, Robot Robot){
    super(Datefin);
    this.Robot = Robot;
  }

  public void execute(){
    Robot.setReservoir(0);
  }
}
