package io;
import io.*;
import gui.*;
import java.awt.*;

import io.TypeRobot;

import java.util.*;
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

    private Chemin trouverPointDeau(Case arrivee, Robot robo){
        /**
         * Trouve le point d'eau le plus proche
         */
         LinkedList<Case> casesDeau = new LinkedList<Case>();
         int nb_cases = this.simu.donnees.GetCarte().GetNbLignes() * this.simu.donnees.GetCarte().GetNbColonnes();
         for (int c=0; c < nb_cases; c++){
             Case current = this.simu.donnees.GetCarte().GetTableauDeCases()[c];
             if (current.GetNature() == NatureTerrain.EAU){
                 casesDeau.add(current);
             }
         }
         long candidat = -1;
         Chemin chem_candidat = null;
         Iterator iter = casesDeau.descendingIterator();
         while (iter.hasNext()){
             Case eau = (Case) iter.next();
             Chemin chem  = new Chemin(arrivee, eau, robo, this.simu);
             if ((chem.getTemps() < candidat) | (candidat == -1)){
                 candidat = chem.getTemps();
                 chem_candidat = chem;
             }
         }
         return chem_candidat;
    }

    private void traiterIncendie(Chemin chem, Incendie incendie){
      /**
      * Donne les ordres au robot d'aller traiter cet incendie sa mère
      */
      int reservoir = chem.getRobot().getReservoir();
      int intensite = incendie.GetIntensite();
      Chemin pointEau = trouverPointDeau(chem.getArrivee(), chem.getRobot());
      chem.deplacement();
      while ( intensite > reservoir ) {
          EvenementDeverserEau vider = new EvenementDeverserEau(simu, chem.getRobot());
          intensite -= reservoir;
          reservoir = 0;
          pointEau.deplacement();
      }

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
                    this.traiterIncendie(chem, incendies[incendie_indice]);
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
        Robot candidat = null;

        for (int incendie_indice = 0; incendie_indice < this.incendiesAffectes.length; incendie_indice++){
          Chemin chemin_candidat = null;
          if (!this.incendiesAffectes[incendie_indice]){
            for (int robot_indice = 0; robot_indice < this.simu.donnees.GetRobots().length; robot_indice++){
              long tempsmin = -1;
                if (robots[robot_indice].getEtat() == Etat.LIBRE){
                    Carte map =this.simu.donnees.GetCarte();
                    Case depart = map.GetTableauDeCases()[map.GetNbColonnes()*robots[robot_indice].GetLigne() + robots[robot_indice].GetColonne()];
                    Case arrivee = map.GetTableauDeCases()[map.GetNbColonnes()*incendies[incendie_indice].GetLigne() + incendies[incendie_indice].GetColonne()];
                    Chemin chem = new Chemin(depart, arrivee, robots[robot_indice],this.simu);
                    if (chem.possible){
                      if ((tempsmin>chem.getTemps()) | tempsmin == -1 ){
                        System.out.println("Mise à jour du temps : le robot "+ robots[robot_indice] + " le fait en " + chem.getTemps());
                        chemin_candidat = chem;
                        candidat = robots[robot_indice];
                        tempsmin = chem.getTemps();
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

            System.out.println(candidat + " en passant par " + chemin_candidat + "pour " + incendies[incendie_indice]);
            if (chemin_candidat != null){
              this.incendiesAffectes[incendie_indice] = true;
              this.traiterIncendie(chemin_candidat, incendies[incendie_indice]);
            }
          }
          else{
              continue;
            }
          }
        }
    }
