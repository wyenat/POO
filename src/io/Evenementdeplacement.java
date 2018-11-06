package io;


public class Evenementdeplacement extends Evenement {
  private Direction direction;
  private Case Case;


  public Evenementdeplacement(Simulateur simu, Robot robot, Direction direction){
    super(robot, simu, ((long) simu.donnees.GetCarte().GetTailleCases()/ (long) robot.GetVitesse()));
    this.Case = simu.donnees.GetCarte().GetTableauDeCases()[0];
    this.direction = direction;
    simu.addEvenement(this);
  }

  public Case getCase(){
      return this.Case;
  }

  public void execute(){
    Simulateur simu = super.getSimu();
    Carte map = simu.donnees.GetCarte();
    Robot robot  = super.getRobot();
    int lig = robot.GetLigne();
    Case C = map.GetTableauDeCases()[(robot.GetLigne())*(map.GetNbLignes()) + robot.GetColonne()];
    this.Case = C;
    if (map.voisinExiste(C, this.direction)){
        this.Case = map.GetVoisin(C, this.direction);
        super.robot = robot;
        boolean possible = false;
        switch (this.robot.GetTypeRobot()) {
          case ROUES:
          Robotaroues Robot_roue = new Robotaroues(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          possible = Robot_roue.test_deplacement(this.Case);
          break;

          case CHENILLES:
          Robotachenilles Robot_chenille = new Robotachenilles(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          possible = Robot_chenille.test_deplacement(this.Case);
          break;

          case PATTES:
          Robotapattes Robot_pattes = new Robotapattes(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          possible = Robot_pattes.test_deplacement(this.Case);
          break;

          case DRONE:
          Robotdrone Robot_drone = new Robotdrone(robot.GetLigne(), robot.GetColonne(), robot.GetVitesse());
          possible = Robot_drone.test_deplacement(this.Case);
          break;

          default:
          break;

        }

        if (possible){
          super.getRobot().setPosition(this.Case);
        }
    }
    else{
      throw new IllegalArgumentException("Le robot ne peut pas aller la");
    }
  }
  public void deplacement(Robot robot, Case C, DonneesSimulation donnees){

    //   switch (robot.GetTypeRobot()) {
    //     case ROUES:
    //       Robotaroues Robot_roue = new Robotaroues(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
    //       break;
    //
    //     case CHENILLES:
    //       Robotachenilles Robot_chenille = new Robotachenilles(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
    //       break;
    //
    //     case PATTES:
    //       Robotapattes Robot_pattes = new Robotapattes(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
    //       break;
    //
    //     case DRONE:
    //       Robotdrone Robot_drone = new Robotdrone(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
    //       Case[] Trajet = Robot_drone.calcul_deplacement(robot, C, donnees);
    //       for (int i =0; i<50; i++){
    //       System.out.println(Trajet[i]);
    //       }
    //       break;
    //
    //     default:
    //       System.out.println("AIE");
    //       break;
    //
    //   }
    //
    //
    }

    @Override
    public String toString(){
        return super.toString() + "Déplacement : le Robot" + (super.getRobot()).toString() + " va en case " + this.getCase().toString();
    }
  }
