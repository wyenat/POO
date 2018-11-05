
import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestScenario0 {
    public static void main(String[] args) {
        try {
          // Mise en place de la simulation.
          Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));

          // Mise en place de la direction ( on ne sait pas faire mieux )
          Direction dir;
          String mdir = "NORD";
          dir = Direction.valueOf(mdir);

          // Mise en place du robot
          Robot drone = simu.donnees.GetRobots()[0];

          // Mise en place des évenements;
          Evenementdeplacement premierDeplacer = new Evenementdeplacement(simu, drone, dir);
          Evenementdeplacement deuxiemeDeplacer = new Evenementdeplacement(simu, drone, dir);
          Evenementdeplacement troisiemeDeplacer = new Evenementdeplacement(simu, drone, dir);
          Evenementdeplacement quatriemeDeplacer = new Evenementdeplacement(simu, drone, dir);
        }
        // Partie levée d'exception
        catch (FileNotFoundException e) {
          System.out.println("fichier " + args[0] + " inconnu ou illisible");
        } catch (DataFormatException e) {
          System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
        }
    }
}
