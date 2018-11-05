package io;


public class EvenementRemplirReservoir extends Evenement {
  private Robot robot;
  private DonneesSimulation Donnees;

  public EvenementRemplirReservoir(long datefin, Robot robot, DonneesSimulation donnees){
    super(datefin);
    this.robot = robot;
    this.Donnees = donnees;
  }

  public void execute(){
    int volume = 0;
    switch (this.robot.GetTypeRobot()) {
        case ROUES:
            Robotaroues Robot_roues = new Robotaroues(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
            volume = Robot_roues.remplirReservoir();
            break;

        case CHENILLES:
            Robotachenilles Robot_chenilles = new Robotachenilles(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
            volume = Robot_chenilles.remplirReservoir();
            break;

        case PATTES:
            Robotapattes Robot_pattes = new Robotapattes(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
            volume = Robot_pattes.remplirReservoir();
            break;

        case DRONE:
            Robotdrone Robot_drone = new Robotdrone(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
            volume = Robot_drone.remplirReservoir();
            break;

        default:
          System.out.println("AIE");
          break;

    }
    this.robot.setReservoir(volume);

  }
}
