package io;


public class EvenementRemplirReservoir extends Evenement {


  public EvenementRemplirReservoir(Simulateur simu, Robot robot){
    super(robot, simu, robot.getDateremplir());
    simu.addEvenement(this);

  }

  public void execute(){
    int ligne = super.getRobot().GetLigne();
    int colonne = super.getRobot().GetColonne();
    int volume = super.getRobot().remplirReservoir(super.getSimu(), ligne, colonne);
    if (volume > 0){
        this.robot.setReservoir(volume);
    }
  }
}
