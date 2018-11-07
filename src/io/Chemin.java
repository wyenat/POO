package io;

import java.util.*;

public class Chemin {
    private Case depart;
    private Case arrivee;
    private Robot robot;
    private Simulateur simu;
    private LinkedList<Case> liste_cases; //correspond au chemin final

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

    public LinkedList<Case> GetListeCases(){
        return this.liste_cases;
    }

    public void SetListeCases(LinkedList<Case> liste){
        this.liste_cases = liste;
    }

    private void iterer(Map<Case, Integer> distance_temporelle, Map<Case, LinkedList<Case>> chemin_jusqua_case){
        /**
         * Itère une fois
         */
         // On parcourt toutes les cases présentes dans le distance_temporelle
         Iterator<Case> cases = distance_temporelle.keySet().iterator();
         // Copie de l'itérateur pour éviter java.util.ConcurrentModificationException
         // Si meilleur solution je suis preneur
         int size = distance_temporelle.keySet().size();
         Case[] copie = new Case[size];
         for (int indice = size; indice>0; indice--){
             copie[size-indice] = cases.next();
         }
         // fin copie
         // Indice sans importance : on parcourt juste toutes les cases
         for (int indice = 0; indice<size; indice++){
             Case current = copie[indice];
             // On vérifie que les voisins existent dans la direction dir
             for (Direction dir : Direction.values()) {
                 if (this.getSimu().donnees.GetCarte().voisinExiste(current, dir)){
                     // On vérifie que le robot peut bien se déplacer sur la case voisine
                     Case voisine = this.simu.donnees.GetCarte().GetVoisin(current, dir);
                     if (!this.getRobot().test_deplacement(voisine)){
                         System.out.println("Case interdite !");
                         break;
                     }
                     // On calcule le temps qu'il faut pour aller à la case voisine
                     Integer dist = new Integer(getDistanceTemp(current, this.getSimu()));
                     // On ajoute ce temps au temps qu'il fallait pour aller à la case courante
                     dist += distance_temporelle.get(current);
                     // On regarde si la case est déjà dans le dico distance_temporelle
                     if (distance_temporelle.containsKey(voisine)){
                         if (dist < distance_temporelle.get(current)){
                             // Le temps est plus petit : un nouveau chemin est trouvé, et plus rapide
                             System.out.println("Temps mis à jour : " + voisine + ". Distance = " + dist +"s");
                             distance_temporelle.put(voisine, dist);
                         }
                     }
                     else{
                         // On ajoute dans le dico la case.
                         System.out.println("Case ajoutée : " + voisine + ". Distance = " + dist +"s");
                         distance_temporelle.put(voisine, dist);
                     }
                 }
             }
         }
     }

    public void calculer(){
        /**
         * Calcule le plus court chemin entre d et a
         *
         * La méthode de calcul est la suivante :
         * - On crée un dictionnaire, qui associe à chaque case sa distance
         *   temporelle à la case de départ.
         * - On la complète en parcourant la carte.
         * - On la retourne lorsque l'itération ne modifie pas le dictionnaire.
         * On stocke en parallèle le chemin pour accéder à la case dans un autre
         * dictionnaire, sous la forme d'une queue.
         */
         Case depart = this.getDepart();
         Case arrivee = this.getArrivee();
         // Création du dictionnaire contenant le temps pour aller dans toutes les autres cases depuis le départ
         Map<Case, Integer> distance_temporelle = new HashMap<Case, Integer> ();
         distance_temporelle.put(depart, 0);
         // Création du dictionnaire contenant la file des cases à parcourir pour aller à la case voulue depuis le départ
         // en temps optimal
         Map<Case, LinkedList<Case>> chemin_jusqua_case = new HashMap<Case, LinkedList<Case>> ();
         int taille_tableau = this.getSimu().donnees.GetCarte().GetNbLignes()* this.getSimu().donnees.GetCarte().GetNbColonnes();
         // Début de l'itération
         int i=0;
         while (this.nonFini(i++)){
             this.iterer(distance_temporelle, chemin_jusqua_case);
         }
         this.SetListeCases(chemin_jusqua_case.get(arrivee));
    }

    public void deplacement(LinkedList<Case> parcourt){
        /*Création des événements pour que le robot se déplace*/
        
    }

    private boolean nonFini(int i){
        /**
         * Vérifie si on a encore besoin d'itérer
         * TODO, là c'est un truc merdique pour boucler trkl
         * N'itère plus quand le tableau chemin_jusqua_case est stable par itération
         */
         return (i!=20);
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
