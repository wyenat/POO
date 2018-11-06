
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

          // System.out.println(46/5);

          // Mise en place des évenements;
          Evenementdeplacement premierDeplacer = new Evenementdeplacement(simu, roues, Direction.NORD);
          // intervention
          EvenementDeverserEau vider = new EvenementDeverserEau(simu, roues, 5, 5);


          Evenementdeplacement deuxiemeDeplacer = new Evenementdeplacement(simu, roues, Direction.OUEST);
          Evenementdeplacement troisiemeDeplacer = new Evenementdeplacement(simu, roues, Direction.OUEST);
          //remplir
          EvenementRemplirReservoir remplir = new EvenementRemplirReservoir(simu, roues, 5, 3);

          Evenementdeplacement quatriemeDeplacer = new Evenementdeplacement(simu, roues, Direction.EST);
          Evenementdeplacement cinquiemeDeplacer = new Evenementdeplacement(simu, roues, Direction.EST);
          //Intervenir
          EvenementDeverserEau vider2 = new EvenementDeverserEau(simu, roues, 5, 5);


      }
      // Partie levée d'exception
      catch (FileNotFoundException e) {
        System.out.println("fichier " + args[0] + " inconnu ou illisible");
      } catch (DataFormatException e) {
        System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
      }
  }
}
