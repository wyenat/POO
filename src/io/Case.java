package io;

public class Case {
  private int ligne;
  private int colonne;
  private NatureTerrain nature;

  public Case(int l, int c, NatureTerrain n){
    /**
    Constructeur de la case
    */
    this.ligne = l;
    this.colonne = c;
    this.nature = n;
  }

  public int GetLigne(){
    return this.ligne;
  }

  public int GetColonne(){
    return this.colonne;
  }

  public NatureTerrain GetNature(){
      /**
       * Retourne la nature de la case
       */
       return this.nature;
  }
}
