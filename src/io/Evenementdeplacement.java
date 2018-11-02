package io;


public class Evenementdeplacement extends Evenement {
  private Robot Robot;
  private Case Case;
  private DonneesSimulation Donnees;


  public Evenementdeplacement(long Datefin, Robot Robot, Case Case){
    super(Datefin);
    this.Robot = Robot;
    this.Case = Case;
  }

  public void execute(){
    Robot.setPosition(Case);
  }
  public void deplacement(Robot robot, Case C/*, DonneesSimulation donnees*/){

      switch (Robot.GetTypeRobot()) {
        case ROUES:
          Robotaroues Robot_roue = new Robotaroues(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
          break;

        case CHENILLES:
          Robotachenilles Robot_chenille = new Robotachenilles(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
          break;

        case PATTES:
          Robotapattes Robot_pattes = new Robotapattes(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
          break;

        case DRONE:
          Robotdrone Robot_drone = new Robotdrone(Robot.GetLigne(), Robot.GetColonne(), Robot.GetVitesse());
          Case[] Trajet = Robot_drone.calcul_deplacement(robot, C/*, donnees*/);
          for (int i =0; i<50; i++){
          System.out.println(Trajet[i]);
          }
          break;

        default:
          System.out.println("AIE");
          break;

      }


    }
  }
