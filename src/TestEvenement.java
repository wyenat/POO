
import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestEvenement {

    public static void main(String[] args) {

        try {
          Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));

          NatureTerrain nature;
          String mmnature = "EAU";
          nature = NatureTerrain.valueOf(mmnature);



          Incendie I = new Incendie(3, 3, 100000);
          EvenementviderReservoir vide = new EvenementviderReservoir(1, simu.donnees.GetRobots()[0], I);

          System.out.println("Intensité de l'incendie avant l'éxécution de l'evenement");
          System.out.println(I.GetIntensite());
          System.out.println("Reservoir de simu.donnees.GetRobots()[0] avant");
          System.out.println(simu.donnees.GetRobots()[0].getReservoir());

          // simu.addEvenement(vide);
          vide.execute();

          System.out.println("Intensité de l'incendie apres l'éxécution de l'evenement");
          System.out.println(I.GetIntensite());
          System.out.println("Reservoir de simu.donnees.GetRobots()[0] apres");
          System.out.println(simu.donnees.GetRobots()[0].getReservoir());


          EvenementRemplirReservoir remplir = new EvenementRemplirReservoir(800, simu.donnees.GetRobots()[0], simu.donnees);
          remplir.execute();
          System.out.println(simu.donnees.GetRobots()[0].getReservoir());

          // simu.addEvenement(remplir);



          Case voisine = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[0].GetLigne() + simu.donnees.GetRobots()[0].GetColonne() +1];
          Evenementdeplacement deplacer = new Evenementdeplacement(simu, simu.donnees.GetRobots()[0], voisine);
          simu.addEvenement(deplacer);

          Case voisine2 = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[1].GetLigne() + simu.donnees.GetRobots()[1].GetColonne() -1];
          Evenementdeplacement deplacer2 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[1], voisine2);
          simu.addEvenement(deplacer2);

          Case voisine3 = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[2].GetLigne() + simu.donnees.GetRobots()[2].GetColonne() -1];
          Evenementdeplacement deplacer3 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[2], voisine3);
          simu.addEvenement(deplacer3);

          Case voisine4 = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[1].GetLigne() + simu.donnees.GetRobots()[1].GetColonne() -2];
          Evenementdeplacement deplacer4 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[1], voisine4);
          simu.addEvenement(deplacer4);

          Case voisine5 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[1].GetLigne()-1) + simu.donnees.GetRobots()[1].GetColonne() -1];
          Evenementdeplacement deplacer5 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[1], voisine5);
          simu.addEvenement(deplacer5);

          Case voisine6 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[2].GetLigne()-1) + simu.donnees.GetRobots()[2].GetColonne() -1];
          Evenementdeplacement deplacer6 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[2], voisine6);
          simu.addEvenement(deplacer6);

        }

        // Partie levée d'exception
        catch (FileNotFoundException e) {
          System.out.println("fichier " + args[0] + " inconnu ou illisible");
        } catch (DataFormatException e) {
          System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
        }





    }

}
