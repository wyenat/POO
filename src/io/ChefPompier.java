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
             if (robo.GetTypeRobot() != TypeRobot.DRONE){
                 Carte carte = this.simu.donnees.GetCarte();
                 Case[] tab = carte.GetTableauDeCases();
                 int lig_case = eau.GetLigne();
                 int col_case = eau.GetColonne();
                 int nb_col = carte.GetNbColonnes();
                 Case voisine = null;
                 for (Direction dir : Direction.values()) {
                    if (carte.voisinExiste(eau, dir)){
                        voisine = carte.GetVoisin(eau,dir);
                        break;
                    } else{
                        System.out.println("PAS DE VOISIN A " + dir + " POUR LA CASE " + voisine);
                        continue;
                    }
                }
                //  System.out.println("Case : " + voisine + " est de type " + voisine.GetNature());
                     if (voisine.GetNature() == NatureTerrain.EAU){continue;}
                    //  System.out.println("On crée donc un chemin");
                     Chemin chem  = new Chemin(arrivee, voisine, robo, this.simu);
                     if ((chem.getTemps() < candidat) | (candidat == -1)){
                         candidat = chem.getTemps();
                         chem_candidat = chem;
                     }
             }
             else{
                 Chemin chem  = new Chemin(arrivee, eau, robo, this.simu);
                 if ((chem.getTemps() < candidat) | (candidat == -1)){
                     candidat = chem.getTemps();
                     chem_candidat = chem;
                 }
             }
        }
        //  System.out.println(chem_candidat);
         return chem_candidat;
    }

    private void traiterIncendie(Chemin chem, Incendie incendie){
      /**
      * Donne les ordres au robot d'aller traiter cet incendie sa mère
      */
      int reservoir = chem.getRobot().getReservoir();
      int intensite = incendie.GetIntensite();
      System.out.println("Point d'eau depuis: " + chem.getArrivee()+ " pour le robot : " + chem.getRobot());
      Chemin pointEau = trouverPointDeau(chem.getArrivee(), chem.getRobot());
      Case nv_arrivee = chem.getArrivee();
      Case case_incendie = chem.getArrivee();
      chem.setArrivee(nv_arrivee);
      chem.deplacement();
      while ( intensite > reservoir) {
        // System.out.println("alors "+ reservoir + " et inten: " + intensite + "robot " + chem.getRobot());
          EvenementDeverserEau vider = new EvenementDeverserEau(simu, chem.getRobot());
          if (chem.getRobot().GetTypeRobot()==TypeRobot.PATTES){
            break;
          }
          intensite -= reservoir;
          reservoir = 0;
          System.out.println(pointEau.getRobot() + " se déplace à l'eau, de " + pointEau.getDepart() +" à " + pointEau.getArrivee());
        //   System.out.println("Le trajet : " + pointEau.afficherTrajet());
          pointEau.deplacement();
          EvenementRemplirReservoir remplir = new EvenementRemplirReservoir(simu, chem.getRobot());
          switch(chem.getRobot().GetTypeRobot()){
            case DRONE:
                reservoir+=10000;
                break;

            case ROUES:
                reservoir+= 5000;
                break;

            case CHENILLES:
                reservoir += 2000;
                break;
          }
          Chemin retour = new Chemin(pointEau.getArrivee(), pointEau.getDepart(), chem.getRobot(), this.simu);
          System.out.println(retour.getRobot() + " se déplace au retour :" + retour.getDepart() +" à " + retour.getArrivee());
        //   System.out.println("Le trajet : " + retour.afficherTrajet());
          retour.deplacement();
      }
    //   System.out.println("dehors "+ reservoir + " et inten: " + intensite);

     EvenementDeverserEau vider = new EvenementDeverserEau(simu, chem.getRobot());

    }

    public void proposer_incendie_naif(){
        Incendie[] incendies =this.simu.donnees.GetIncendies();
        Robot[] robots =this.simu.donnees.GetRobots();
        for (int incendie_indice = 0; incendie_indice < this.incendiesAffectes.length; incendie_indice++){
          if (!this.incendiesAffectes[incendie_indice]){
            for (int robot_indice = 0; robot_indice < this.simu.donnees.GetRobots().length; robot_indice++){
              if (robots[robot_indice].getEtat() == Etat.LIBRE){
                  Carte map =this.simu.donnees.GetCarte();
                  Case depart = map.GetTableauDeCases()[map.GetNbColonnes()*robots[robot_indice].GetLigne() + robots[robot_indice].GetColonne()];
                  Case arrivee = map.GetTableauDeCases()[map.GetNbColonnes()*incendies[incendie_indice].GetLigne() + incendies[incendie_indice].GetColonne()];
                  Chemin chem = new Chemin(depart, arrivee, robots[robot_indice],this.simu);
                  if (chem.possible){
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
          }
          else{
            continue;
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
                        // System.out.println("Mise à jour du temps : le robot "+ robots[robot_indice] + " le fait en " + chem.getTemps());
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

            // System.out.println(candidat + " en passant par " + chemin_candidat + "pour " + incendies[incendie_indice]);
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
