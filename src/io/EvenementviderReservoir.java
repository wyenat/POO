
package io;



public class EvenementviderReservoir extends Evenement {
  private Robot robot;
  private Incendie incendie;
  private DonneesSimulation Donnees;


  public EvenementviderReservoir(long Datefin, Robot robot, Incendie incendie){
    super(Datefin);
    this.robot = robot;
    this.incendie = incendie;

  }

  public void execute(){
      int possible = 0;
      switch (this.robot.GetTypeRobot()) {
        case ROUES:
          Robotaroues Robot_roue = new Robotaroues(robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          possible = Robot_roue.testVider(this.incendie);
          break;

        case CHENILLES:
          Robotachenilles Robot_chenille = new Robotachenilles(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          possible = Robot_chenille.testVider(this.incendie);
          break;

        case PATTES:
          Robotapattes Robot_pattes = new Robotapattes(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          possible = Robot_pattes.testVider(this.incendie);
          break;

        case DRONE:
          Robotdrone Robot_drone = new Robotdrone(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          possible = Robot_drone.testVider(this.incendie);
          break;

        default:
          System.out.println("AIE");
          break;
      }

      if (possible == 0){
        return;
      }

      int reste = this.robot.getReservoir();
      int intensite = incendie.GetIntensite();
      if (intensite - reste < 0 ){
        this.robot.setReservoir(reste - intensite);
        incendie.setIntensite(0);
      }
      else {
        this.robot.setReservoir(0);
        incendie.setIntensite(intensite - reste);
      }
  }
}
