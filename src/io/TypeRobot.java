package io;

public enum TypeRobot {
  Drone ("drone"),
  RobotARoues ("robot_a_roues"),
  RobotAChenilles ("robot_a_chenilles"),
  RobotAPattes ("robot_a_pattes");

  private String name = "";

  /**
  Constructeur
  */
  TypeRobot(String name){
    this.name = name;
  }

  public String toString(){
    return name;
  }
}
