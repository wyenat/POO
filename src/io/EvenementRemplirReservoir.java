package io;


public class EvenementRemplirReservoir extends Evenement {
    private int ligne;
    private int colonne;

  public EvenementRemplirReservoir(Simulateur simu, Robot robot, int lig, int col){
    super(robot, simu, robot.getDateremplir());
    this.ligne = lig;
    this.colonne = col;
    simu.addEvenement(this);

  }

  public void execute(){
    int volume = 0;
    switch (super.getRobot().GetTypeRobot()) {
        case ROUES:
            Robotaroues Robot_roues = new Robotaroues(super.getRobot().GetLigne(), super.getRobot().GetColonne(), super.getRobot().GetVitesse());
            volume = Robot_roues.remplirReservoir(super.getSimu(), this.ligne, this.colonne);
            break;

        case CHENILLES:
            Robotachenilles Robot_chenilles = new Robotachenilles(super.getRobot().GetLigne(), super.getRobot().GetColonne(), super.getRobot().GetVitesse());
            volume = Robot_chenilles.remplirReservoir(super.getSimu(), this.ligne, this.colonne);
            break;

        case PATTES:
            Robotapattes Robot_pattes = new Robotapattes(super.getRobot().GetLigne(), super.getRobot().GetColonne(), super.getRobot().GetVitesse());
            volume = Robot_pattes.remplirReservoir(super.getSimu(), this.ligne, this.colonne);
            break;

        case DRONE:
            System.out.println("AAAAAh");
            Robotdrone Robot_drone = new Robotdrone(super.getRobot().GetLigne(), super.getRobot().GetColonne(), super.getRobot().GetVitesse());
            volume = Robot_drone.remplirReservoir(super.getSimu(), this.ligne, this.colonne);
            break;

        default:
          System.out.println("AIE");
          break;

    }
    if (volume > 0){

        this.robot.setReservoir(volume);
    }

  }
}
