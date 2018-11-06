
import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestScenario1 {
    public static void main(String[] args) {
        try {
          // Mise en place de la simulation.
          Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));

          // Mise en place du robot
          Robot roues = simu.donnees.GetRobots()[1];

          // Mise en place des évenements;
          Evenementdeplacement premierDeplacer = new Evenementdeplacement(simu, roues, Direction.NORD);
          // intervention
          Evenementdeplacement deuxiemeDeplacer = new Evenementdeplacement(simu, roues, Direction.OUEST);
          Evenementdeplacement troisiemeDeplacer = new Evenementdeplacement(simu, roues, Direction.OUEST);
          //remplir
          Evenementdeplacement quatriemeDeplacer = new Evenementdeplacement(simu, roues, Direction.EST);
          Evenementdeplacement cinquiemeDeplacer = new Evenementdeplacement(simu, roues, Direction.EST);
          //Intervenir


      }
      // Partie levée d'exception
      catch (FileNotFoundException e) {
        System.out.println("fichier " + args[0] + " inconnu ou illisible");
      } catch (DataFormatException e) {
        System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
      }
  }
}
