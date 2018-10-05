package io;

public enum NatureTerrain {
  Eau ("eau"),
  Foret ("foret"),
  Roche ("roche"),
  TerrainLibre ("terrain libre"),
  Habitat ("habitat");

  private String name = "";

  /**
  Constructeur
  */
  NatureTerrain(String name){
    this.name = name;
  }

  public String toString(){
    return name;
  }
}
