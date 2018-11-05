
package io;



public class EvenementDeverserEau extends Evenement {
    private int ligne;
    private int colonne;

  public EvenementDeverserEau(Simulateur simu, Robot robot, int lig, int col){
    super(robot, simu, robot.getDatevider());
    this.colonne = col;
    this.ligne = lig;
    simu.addEvenement(this);

  }

  public void execute(){
      int volume = 0;
      Robot robot = super.getRobot();
      switch (robot.GetTypeRobot()) {
        case ROUES:
          Robotaroues Robot_roue = new Robotaroues(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          volume = Robot_roue.Vider(super.getSimu(), this.ligne, this.colonne);
          break;

        case CHENILLES:
          Robotachenilles Robot_chenille = new Robotachenilles(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          volume = Robot_chenille.Vider(super.getSimu(), this.ligne, this.colonne);
          break;

        case PATTES:
          Robotapattes Robot_pattes = new Robotapattes(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          volume = Robot_pattes.Vider(super.getSimu(), this.ligne, this.colonne);
          break;

        case DRONE:
          Robotdrone Robot_drone = new Robotdrone(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          volume = Robot_drone.Vider(super.getSimu(), this.ligne, this.colonne);
          break;

        default:
          System.out.println("AIE");
          break;
      }

      if (volume  == 0){
        return;
      }
      Incendie[] incendies = super.getSimu().donnees.GetIncendies();
      Incendie incendie = incendies[0];
      for (int i=0; i<incendies.length; i++){
        if (incendies[i].GetLigne()==this.ligne && incendies[i].GetColonne()==this.colonne){
          incendie = incendies[i];

        }
      }
      int intensite = incendie.GetIntensite();
      int reste = super.robot.getReservoir();
      System.out.println(volume);
      if (intensite - reste < 0 ){
        super.robot.setReservoir(reste - intensite);
      }
      else {
        super.robot.setReservoir(0);
      }
  }
}
