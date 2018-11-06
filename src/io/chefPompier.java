// package io;
import io.*;
import gui.*;
import java.awt.*;

import io.TypeRobot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class chefPompier {
    Simulateur simu;
    int[] incendiesAffectes;

    public chefPompier(Simulateur simu){
        this.simu = simu;
        this.incendiesAffectes[] = new int[simu.donnees.GetIncendies().length];
        for (int i =0; i<this.incendiesAffectes.length; i++){
            this.incendiesAffectes[i] =0;
        }
    }

    private void traiterIncendie(Robot rob, Simulateur simu){
      /**
      * Donne les ordres au robot d'aller traiter cet incendie sa mère
      */
      TODO;
    }

    public void proposer_incendie_naif(){
        Incendie[] incendies = simu.donnees.GetIncendies();
        Robot[] robots = simu.donnees.getRobot();
        for (int incendie_indice = 0; incendie_indice < this.incendiesAffectes.length; incendie_indice++){
          for (int robot_indice = 0; robot_indice < this.simu.donnees.GetRobots().length; robot_indice++){
            if (robot[robot_indice].getEtat() == LIBRE){
              if (Chemin.deplacement_possible(robot)){
                //TRICHE²
                this.incendiesAffectes[incendie_indice] = 1;
                this.traiterIncendie(robots[robot_indice], this.simu)
              }
            }
          }
        }
    }

}
