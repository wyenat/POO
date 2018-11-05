
import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestScenario1 {
    public static void main(String[] args) {
        try {
          // Mise en place de la simulation.
          Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));

          // Mise en place de la direction ( on ne sait pas faire mieux )
          Direction dirN;
          Direction dirO;
          Direction dirE;
          String mdirN = "NORD";
          String mdirO = "OUEST";
          String mdirE = "EST";
          dirN = Direction.valueOf(mdirN);
          dirO = Direction.valueOf(mdirO);
          dirE = Direction.valueOf(mdirE);

          // Mise en place du robot
          Robot roues = simu.donnees.GetRobots()[1];

          // Mise en place des évenements;
          Evenementdeplacement premierDeplacer = new Evenementdeplacement(simu, roues, dirN);
          // intervention
          Evenementdeplacement deuxiemeDeplacer = new Evenementdeplacement(simu, roues, dirO);
          Evenementdeplacement troisiemeDeplacer = new Evenementdeplacement(simu, roues, dirO);
          //remplir
          Evenementdeplacement quatriemeDeplacer = new Evenementdeplacement(simu, roues, dirE);
          Evenementdeplacement cinquiemeDeplacer = new Evenementdeplacement(simu, roues, dirE);
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
