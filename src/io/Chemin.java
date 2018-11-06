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
         return ((int) simu.donnees.GetCarte().GetTailleCases()/ (int) this.getRobot().GetVitesse());
    }

    private void iterer(Map<Case, Integer> distance_temporelle, Map<Case, LinkedList<Case>> chemin_jusqua_case){
        /**
         * Itère une fois
         */
         Iterator<Case> cases = distance_temporelle.keySet().iterator();
         for (int indice = distance_temporelle.keySet().size(); indice>0; indice--){
             Case current = cases.next();
             System.out.println(current);
             for (Direction dir : Direction.values()) {
                 if (this.getSimu().donnees.GetCarte().voisinExiste(current, dir)){
                     System.out.println("Il y a un voisin de " + current.toString() + "à " + dir.toString());
                     Integer dist = new Integer(getDistanceTemp(current, this.getSimu()));
                     distance_temporelle.put(this.getSimu().donnees.GetCarte().GetVoisin(current, dir), dist);
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
          ArrayList<LinkedList<Case>> tableau_de_chemin = new ArrayList(taille_tableau);
          distance_temporelle.put(depart, 0);
          this.iterer(distance_temporelle, chemin_jusqua_case);
          this.iterer(distance_temporelle, chemin_jusqua_case);
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
