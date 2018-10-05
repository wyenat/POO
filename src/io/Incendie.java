package io;

public class Incendie{
  /**
  Un incendie est défini par sa position et par son intensité (nb de litres d'eau
  nécessaires pour l'éteindre)
  */
  private Case position;
  private int nb_litres_extinction;

  public Incendie(Case pos, int nbl){
    this.position = pos;
    this.nb_litres_extinction = nbl;
  }

}
