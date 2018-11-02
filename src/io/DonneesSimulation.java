package io;

import io.Simulateur;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class DonneesSimulation{

    private Carte carte;
    private Incendie[] incendies;
    private Robot[] robots;

    public DonneesSimulation(Carte c, Incendie i[], Robot r[]){
        /**
         * Constucteur de DonneesSimulation
         */
         this.SetCarte(c);
         this.SetIncendies(i);
         this.SetRobot(r);
     }

    //  public DonneesSimulation RecupererDonnees(String fichierDonnees){
    //      /**
    //       * Constucteur qui ne prends que le nom du fichier
    //       */
    //       DonneesSimulation donneesSimulation;
    //       try {
    //           donneesSimulation = LecteurDonnees.lire(fichierDonnees);
    //       } catch (FileNotFoundException e) {
    //           System.out.println("fichier " + fichierDonnees + " inconnu ou illisible");
    //       } catch (DataFormatException e) {
    //           System.out.println("\n\t**format du fichier " + fichierDonnees + " invalide: " + e.getMessage());
    //       }
    //       donneesSimulation = LecteurDonnees.lire(fichierDonnees);
    //       return donneesSimulation;
    //  }

     public void SetCarte(Carte c){
         this.carte =c ;
     }

     public void SetIncendies(Incendie i[]){
         this.incendies = i;
     }

     public void SetRobot(Robot r[]){
         this.robots = r;
     }

     public Carte GetCarte(){
         return this.carte;
     }

     public Incendie[] GetIncendies(){
         return this.incendies;
     }

     public Robot[] GetRobots(){
         return this.robots;
     }

    private static String AfficherIncendies(Incendie[] incendies){
        /**
         * Affiche les incendies
         */
         String returned_string = "\n\n\t#Incendies";
         for (int i=0; i<incendies.length; i++){
             returned_string += "\nIncendie " + i + ": Position : (" + incendies[i].GetLigne()
                    + "," + incendies[i].GetColonne() + ")\tIntensité : "
                    + incendies[i].GetIntensite();
         }
         return returned_string;
    }

    private static String AfficherRobots(Robot[] robots){
        /**
         * Affiche les robots
         */
         String stringReturned = "\n\n\t#Robots";
         for (int i=0; i<robots.length; i++){
             stringReturned += "\nRobot " + i + ": Position : (" + robots[i].GetLigne()
                    + "," + robots[i].GetColonne() + ")\t type : " + "\t Vitesse : " + robots[i].GetVitesse();
         }
         return stringReturned;
    }

    public String afficher(){
        String stringReturned = "\t #Carte" + this.carte.ToString();
        stringReturned += AfficherIncendies(this.incendies) + AfficherRobots(this.robots);
        return stringReturned;
    }
}
