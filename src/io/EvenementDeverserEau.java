
package io;



public class EvenementDeversereau extends Evenement {


  public EvementDeverserEau(Simulateur simu, Robot robot){
    super(robot, simu, robot.getDatevider());

  }

  public void execute(){
      int possible = 0;
      switch (this.robot.GetTypeRobot()) {
        case ROUES:
          Robotaroues Robot_roue = new Robotaroues(robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          volume = Robot_roue.Vider();
          break;

        case CHENILLES:
          Robotachenilles Robot_chenille = new Robotachenilles(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          volume = Robot_chenille.Vider();
          break;

        case PATTES:
          Robotapattes Robot_pattes = new Robotapattes(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          volume = Robot_pattes.Vider();
          break;

        case DRONE:
          Robotdrone Robot_drone = new Robotdrone(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
          volume = Robot_drone.Vider();
          break;

        default:
          System.out.println("AIE");
          break;
      }

      if (volume  == 0){
        return;
      }

      int reste = this.robot.getReservoir();
      int volume = volume;
      if (intensite - reste < 0 ){
        this.robot.setReservoir(reste - intensite);
      }
      else {
        this.robot.setReservoir(0);
      }
  }
}
