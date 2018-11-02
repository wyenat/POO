
package io;



public class EvenementviderReservoir extends Evenement {
  private Robot Robot;
  private Incendie incendie;
  private DonneesSimulation Donnees;


  public EvenementviderReservoir(long Datefin, Robot Robot){
    super(Datefin);
    this.Robot = Robot;
  }

  public void execute(){
      int reste = super.getReservoir();
      super.setReservoir(0);
      int intensite = incendie.GetIntensite();
      if (intensite - reste < 0 ){
        incendie.setIntensite(0);
      }
      else {
        incendie.setIntensite(intensite - reste);
      }
  }
}
