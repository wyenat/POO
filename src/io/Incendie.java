package io;

public class Incendie{
  /**
  Un incendie est défini par sa position et par son intensité (nb de litres d'eau
  nécessaires pour l'éteindre)
  */
  private int ligne;
  private int colonne;
  private int nb_litres_extinction;

  public Incendie(int lig, int col, int nbl){
    this.ligne = lig;
    this.colonne = col;
    this.nb_litres_extinction = nbl;
  }

  public int GetLigne(){
      return this.ligne;
  }

  public int GetColonne(){
      return this.colonne;
  }

  public int GetIntensite(){
      return this.nb_litres_extinction;
  }

}
