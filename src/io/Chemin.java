package io;

import java.util.*;

public class Chemin {
    private Case depart;
    private Case arrivee;
    private Robot robot;
    private Simulateur simu;

    public Chemin(Case d, Case a, Robot r, Simulateur s){
        this.setDepart(d);
        this.setArrivee(a);
        this.setRobot(r);
        this.setSimu(s);
    }

    private int getDistanceTemp(Case courante, Simulateur simu){
        /**
         * Calcule le temps que met le robot à aller à une autre case depuis
         * la case départ
         */
         return (simu.donnees.GetCarte().GetTailleCases()/ (int) this.getRobot().GetVitesse());
    }

    private void iterer(Map<Case, Integer> distance_temporelle, Map<Case, LinkedList<Case>> chemin_jusqua_case){
        /**
         * Itère une fois
         */
         Iterator<Case> cases = distance_temporelle.keySet().iterator();
         // Copie de l'itérateur pour éviter java.util.ConcurrentModificationException
         // Si meilleur solution je suis preneur
         int size = distance_temporelle.keySet().size();
         Case[] copie = new Case[size];
         for (int indice = size; indice>0; indice--){
             copie[size-indice] = cases.next();
         }
         // fin copie
         for (int indice = 0; indice<size; indice++){
             Case current = copie[indice];
             for (Direction dir : Direction.values()) {
                 if (this.getSimu().donnees.GetCarte().voisinExiste(current, dir)){
                     Case voisine = this.getSimu().donnees.GetCarte().GetVoisin(current, dir);
                     if (!this.getRobot().test_deplacement(voisine)){
                         System.out.println("\n \n Case interdite !");
                         break;
                     }
                     Integer dist = new Integer(getDistanceTemp(current, this.getSimu()));
                     dist += distance_temporelle.get(current);
                     if (distance_temporelle.containsKey(voisine)){
                         if (dist < distance_temporelle.get(current)){
                             System.out.println("Temps mis à jour : " + voisine + ". Distance = " + dist +"s");
                             distance_temporelle.put(voisine, dist);
                         }
                     }
                     else{
                         System.out.println("\n Case ajoutée : " + voisine + ". Distance = " + dist +"s");
                         distance_temporelle.put(voisine, dist);
                     }
                 }
             }
         }
     }

    public void calculer(){
        /**
         * Calcule le plus court chemin entre d et a, et crée les évènements
         * pour que le robot s'y déplace effectivement.
         *
         * La méthode de calcul est la suivante :
         * - On crée un dictionnaire, qui associe à chaque case sa distance
         *   temporelle à la case de départ.
         * - On la complète en parcourant la carte.
         * - On la retourne lorsque l'itération ne modifie pas le dictionnaire.
         * On stoque en parallèle le chemin pour accéder à la case dans un autre
         * dictionnaire, sous la forme d'une queue.
         */
          Map<Case, Integer> distance_temporelle = new HashMap<Case, Integer> ();
          Map<Case, LinkedList<Case>> chemin_jusqua_case = new HashMap<Case, LinkedList<Case>> ();
          Case depart = this.getDepart();
          Case arrivee = this.getArrivee();
          int taille_tableau = this.getSimu().donnees.GetCarte().GetNbLignes()* this.getSimu().donnees.GetCarte().GetNbColonnes();
          ArrayList<LinkedList<Case>> tableau_de_chemin = new ArrayList<LinkedList<Case>>(taille_tableau);
          distance_temporelle.put(depart, 0);
          int i=0;
          while (this.nonFini(i++)){
              this.iterer(distance_temporelle, chemin_jusqua_case);
          }
    }

    private boolean nonFini(int i){
        /**
         * Vérifie si on a encore besoin d'itérer
         * TODO, là c'est un truc merdique pour boucler trkl
         */
         return (i!=5);
    }

    // Set et get...
    public void setDepart(Case d){
    this.depart = d;
    }

    public Case getDepart(){
    return this.depart;
    }

    public void setArrivee(Case a){
    this.arrivee = a;
    }

    public Case getArrivee(){
    return this.arrivee;
    }

    public void setRobot(Robot r){
    this.robot = r;
    }

    public Robot getRobot(){
    return this.robot;
    }

    public void setSimu(Simulateur simu){
    this.simu = simu;
    }

    public Simulateur getSimu(){
    return this.simu;
    }
    // Fin set et get...
}
