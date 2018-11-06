import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestChemin {
    public static void main(String[] args) {
        try {
          // Mise en place de la simulation.
          Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));
          Case depart = simu.donnees.GetCarte().GetTableauDeCases()[0];
          Case arrivee = simu.donnees.GetCarte().GetTableauDeCases()[1];
          Robot robot = simu.donnees.GetRobots()[1];
          Chemin route = new Chemin(depart, arrivee, robot, simu);
          route.calculer();
        }
          // Partie levée d'exception
          catch (FileNotFoundException e) {
            System.out.println("fichier " + args[0] + " inconnu ou illisible");
          } catch (DataFormatException e) {
            System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
          }
    }
}
