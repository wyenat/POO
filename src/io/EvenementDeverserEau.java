
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
      Robot robot = super.getRobot();
      Incendie[] incendies = super.getSimu().donnees.GetIncendies();
      Incendie incendie = incendies[0];
      for (int i=0; i<incendies.length; i++){
        if (incendies[i].GetLigne()==this.ligne && incendies[i].GetColonne()==this.colonne){
          incendie = incendies[i];
        }
      }
      int intensite = incendie.GetIntensite();
      int reservoir = super.robot.getReservoir();
      if (intensite == 0){
        throw new IllegalArgumentException("L'incendie a déjà été éteint ici");
      }

      int volume = robot.Vider(super.getSimu(), this.ligne, this.colonne, intensite);


      if (volume  == 0){
      }
        return;
      // System.out.println(volume);
      // if (intensite - reste < 0 ){
      //   super.robot.setReservoir(reste - intensite);
      //   incendie.setIntensite(0);
      // }
      // else {
      //   super.robot.setReservoir(0);
      //   incendie.setIntensite(intensite - reste);
      }




  }
