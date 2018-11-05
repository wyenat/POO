package io;


public class Evenementdeplacement extends Evenement {
  private Robot robot;
  private Direction direction;
  private Case Case;


  public Evenementdeplacement(Simulateur simu, Robot robot, Direction direction){
    super(simu.time + ((long) simu.donnees.GetCarte().GetTailleCases()/ (long) robot.GetVitesse()));
    Carte map = simu.donnees.GetCarte();
    Case C = map.GetTableauDeCases()[robot.GetLigne()*map.GetNbLignes() + robot.GetColonne()];
    System.out.println(map.voisinExiste(C, direction));
    if (map.voisinExiste(C, direction)){
        this.Case = map.GetVoisin(C, direction);
        this.robot = robot;
    }
    else{
      throw new IllegalArgumentException("Le robot ne peut pas sortir de la carte");
    }
  }

  public Robot getRobot(){
      return this.robot;
  }

  public Case getCase(){
      return this.Case;
  }

  public void execute(){
    boolean possible = false;
    switch (this.robot.GetTypeRobot()) {
      case ROUES:
        Robotaroues Robot_roue = new Robotaroues(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
        possible = Robot_roue.test_deplacement(this.Case);
        break;

      case CHENILLES:
        Robotachenilles Robot_chenille = new Robotachenilles(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
        possible = Robot_chenille.test_deplacement(this.Case);
        break;

      case PATTES:
        Robotapattes Robot_pattes = new Robotapattes(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
        possible = Robot_pattes.test_deplacement(this.Case);
        break;

      case DRONE:
        Robotdrone Robot_drone = new Robotdrone(this.robot.GetLigne(), this.robot.GetColonne(), this.robot.GetVitesse());
        possible = Robot_drone.test_deplacement(this.Case);
        break;

      default:
        System.out.println("AIE");
        break;

    }

    if (possible){
        this.robot.setPosition(this.Case);
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
        return super.toString() + "Déplacement : le Robot" + this.getRobot().toString() + " va en case " + this.getCase().toString();
    }
  }
