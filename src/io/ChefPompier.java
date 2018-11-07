package io;
import io.*;
import gui.*;
import java.awt.*;

import io.TypeRobot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ChefPompier {
    Simulateur simu;
    boolean[] incendiesAffectes;

    public ChefPompier(Simulateur simu){
        this.simu = simu;
        this.incendiesAffectes = new boolean[simu.donnees.GetIncendies().length];
        for (int i =0; i<this.incendiesAffectes.length; i++){
            this.incendiesAffectes[i] =false;
        }
    }

    private void traiterIncendie(Chemin chem){
      /**
      * Donne les ordres au robot d'aller traiter cet incendie sa mère
      */
      //tODO;
      chem.deplacement();
      EvenementDeverserEau vider = new EvenementDeverserEau(simu, chem.getRobot());
    }

    public void proposer_incendie_naif(){
        Incendie[] incendies =this.simu.donnees.GetIncendies();
        Robot[] robots =this.simu.donnees.GetRobots();
        for (int incendie_indice = 0; incendie_indice < this.incendiesAffectes.length; incendie_indice++){
          for (int robot_indice = 0; robot_indice < this.simu.donnees.GetRobots().length; robot_indice++){
            if (!this.incendiesAffectes[incendie_indice]){
              if (robots[robot_indice].getEtat() == Etat.LIBRE){
                  Carte map =this.simu.donnees.GetCarte();
                  Case depart = map.GetTableauDeCases()[map.GetNbColonnes()*robots[robot_indice].GetLigne() + robots[robot_indice].GetColonne()];
                  Case arrivee = map.GetTableauDeCases()[map.GetNbColonnes()*incendies[incendie_indice].GetLigne() + incendies[incendie_indice].GetColonne()];
                  Chemin chem = new Chemin(depart, arrivee, robots[robot_indice],this.simu);
                  if (chem.possible){
                    //TRICHE
                    this.incendiesAffectes[incendie_indice] = true;
                    this.traiterIncendie(chem);
                  }
                  else{
                    continue;
                  }
              }
              else{
                continue;
              }
            }
            else{
              continue;
                }
          }
        }
    }


    public void proposer_incendie_evolue(){
        Incendie[] incendies = this.simu.donnees.GetIncendies();
        Robot[] robots = this.simu.donnees.GetRobots();
        Robot candidat = new Robotdrone(0, 0, 0);

        for (int incendie_indice = 0; incendie_indice < this.incendiesAffectes.length; incendie_indice++){
          Chemin chemin_candidat = new Chemin(new Case(0, 0, NatureTerrain.EAU), new Case(0, 0, NatureTerrain.EAU), robots[0], this.simu);
          if (!this.incendiesAffectes[incendie_indice]){
            for (int robot_indice = 0; robot_indice < this.simu.donnees.GetRobots().length; robot_indice++){
              long tempsmin = 1000000; //TRICHE mais je sais pas comment init
                if (robots[robot_indice].getEtat() == Etat.LIBRE){
                    Carte map =this.simu.donnees.GetCarte();
                    Case depart = map.GetTableauDeCases()[map.GetNbColonnes()*robots[robot_indice].GetLigne() + robots[robot_indice].GetColonne()];
                    Case arrivee = map.GetTableauDeCases()[map.GetNbColonnes()*incendies[incendie_indice].GetLigne() + incendies[incendie_indice].GetColonne()];
                    Chemin chem = new Chemin(depart, arrivee, robots[robot_indice],this.simu);
                    if (chem.possible){
                      if (tempsmin>chem.getTemps()){
                        chemin_candidat = chem;
                        candidat = robots[robot_indice];
                        tempsmin = chem.getTemps();
                      }
                    }
                    else{
                      continue;
                    }
                }
                else{
                  continue;
                }

            }

            System.out.println(candidat + " en passant par " + chemin_candidat + "pour " + incendies[incendie_indice]);
            if (chemin_candidat.getDepart() != chemin_candidat.getArrivee()){
              this.incendiesAffectes[incendie_indice] = true;
              this.traiterIncendie(chemin_candidat);
            }
          }
          else{
              continue;
            }
          }
        }
    }
