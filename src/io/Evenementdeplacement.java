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
        boolean possible = robot.test_deplacement(this.Case);

        if (possible){
          super.getRobot().setPosition(this.Case);
        }
    }
    else{
      throw new IllegalArgumentException("Le robot ne peut pas aller la");
    }
  }
  

    @Override
    public String toString(){
        return super.toString() + "Déplacement : le Robot" + (super.getRobot()).toString() + " va en case " + this.getCase().toString();
    }
  }
