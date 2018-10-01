package io;

// import java.io.Carte;
import java.io.Carte;

public class Robotaroues extend Robot{

    /* Attributs relatifs aux robots à roues et fonctions associées*/

    public void setPosition(Case C){
      /* Change la case sur laquelle est le robot si c'est possible*/
      if (C.NatureTerrain == "TERRAIN LIBRE" ||  C.NatureTerrain == "HABITAT"){
        this.position = C;
      }
      else{
        throw new IllegalArgumentException("Ce Robot ne peut pas aller sur cette case");
      }
    }

    public double getVitesse(NatureTerrain Nature){
      /* On regarde la vitesse du robot sur un type de terrain particulier*/
      if (Nature == "TERRAIN LIBRE" ||  Nature == "HABITAT"){
        /*On vérifie qu'il puisse aller sur ce terrain*/
        return this.vitesse;
      }
      else{
        return 0;
      }
    }

    public void deverserEau(int Volume){
      if (Volume<=this.litres_en_reserve){
        /*On vérifie qu'il puisse verser autant de litres*/
        this.litres_en_reserve = this.litres_en_reserve - Volume;
      }
      else{
        throw new IllegalArgumentException("On ne peut pas verser autant d'eau");
      }
    }


}
