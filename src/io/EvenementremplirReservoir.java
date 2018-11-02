package io;


public class EvenementRemplirReservoir extends Evenement {
  private Robot Robot;
  private DonneesSimulation Donnees;

  public EvenementRemplirReservoir(long Datefin, Robot Robot){
    super(Datefin);
    this.Robot = Robot;
  }

  public void execute(){
    switch (Robot.GetTypeRobot()) {
        case ROUES:
            Robotaroues Robot_new = new Robotaroues(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
            break;

        case CHENILLES:
            Robotachenilles Robot_new = new Robotachenilles(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
            break;

        case PATTES:
            Robotapattes Robot_new = new Robotapattes(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
            break;

        case ROUES:
            Robotdrone Robot_new = new Robotdrone(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
            break;

        default:
          System.out.println("AIE");
          break;

    }
    Robot_new.remplirReservoir()
  }
}
