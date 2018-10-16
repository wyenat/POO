

public class Evenement{
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


}

public class Evenementdeplacement extends Evenement{
  private Robot Robot;
  private Case Case;

  public Evenementdeplacement(long Datefin, Robot Robot, Case Case){
    super(Datefin);
    this.Robot = Robot;
    this.Case = Case;
  }

  private void execute(){
    Robot.setPosition(Case);
  }
}
