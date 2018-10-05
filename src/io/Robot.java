package io;

public class Robot {
  private TypeRobot type;
  private Case position;
  private int vitesse_deplacement;

  public Robot(TypeRobot type, Case position, int vitesse_deplacement){
    this.type = type;
    this.position = position;
    this.vitesse_deplacement = vitesse_deplacement;
  }
}
