
import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestEvenement {

    public static void main(String[] args) {

        try {
          Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));
          //
          // NatureTerrain nature;
          // String mmnature = "EAU";
          // nature = NatureTerrain.valueOf(mmnature);


          //
          // Incendie I = new Incendie(3, 3, 100000);
          // EvementDeverserEau vide = new EvementDeverserEau(1, simu.donnees.GetRobots()[0], I);
          //
          // System.out.println("Intensité de l'incendie avant l'éxécution de l'evenement");
          // System.out.println(I.GetIntensite());
          // System.out.println("Reservoir de simu.donnees.GetRobots()[0] avant");
          // System.out.println(simu.donnees.GetRobots()[0].getReservoir());
          //
          // // simu.addEvenement(vide);
          // vide.execute();
          //
          // System.out.println("Intensité de l'incendie apres l'éxécution de l'evenement");
          // System.out.println(I.GetIntensite());
          // System.out.println("Reservoir de simu.donnees.GetRobots()[0] apres");
          // System.out.println(simu.donnees.GetRobots()[0].getReservoir());


          // EvenementRemplirReservoir remplir = new EvenementRemplirReservoir(800, simu.donnees.GetRobots()[0], simu.donnees);
          // remplir.execute();
          // System.out.println(simu.donnees.GetRobots()[0].getReservoir());

          // simu.addEvenement(remplir);

          Direction dir;
          String mdir = "NORD";
          dir = Direction.valueOf(mdir);

          Robot Vivien = simu.donnees.GetRobots()[0];

          Evenementdeplacement deplacer = new Evenementdeplacement(simu, Vivien, dir);


          Evenementdeplacement deplacerencore = new Evenementdeplacement(simu, Vivien, dir);

          while(simu.time <= deplacerencore.getDate()){
            System.out.println("2");
          }

          Evenementdeplacement deplacerencoreencore = new Evenementdeplacement(simu, Vivien, dir);

          while(simu.time <= deplacerencoreencore.getDate()){
            System.out.println("3");
          }
          Evenementdeplacement deplacerencoreencorencore = new Evenementdeplacement(simu, Vivien, dir);
        //
        //
        //
        //   Case voisine7 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[0].GetLigne()+2) + simu.donnees.GetRobots()[0].GetColonne()];
        //   Evenementdeplacement deplacer7 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[0], voisine7);
        //   simu.addEvenement(deplacer7);
        //
        //
        //   Case voisine8 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[0].GetLigne()+3) + simu.donnees.GetRobots()[0].GetColonne()];
        //   Evenementdeplacement deplacer8 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[0], voisine8);
        //   simu.addEvenement(deplacer8);
        //
        //
        //
        //   Case voisine9 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[0].GetLigne()+4) + simu.donnees.GetRobots()[0].GetColonne()];
        //   Evenementdeplacement deplacer9 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[0], voisine9);
        //   simu.addEvenement(deplacer9);
        //
        //
        //  Case voisine10 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[0].GetLigne()+4) + simu.donnees.GetRobots()[0].GetColonne()-1];
        //  Evenementdeplacement deplacer10 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[0], voisine10);
        //  simu.addEvenement(deplacer10);
        //
        //
        //  Case voisine11 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[0].GetLigne()+4) + simu.donnees.GetRobots()[0].GetColonne()-2];
        //  Evenementdeplacement deplacer11 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[0], voisine11);
        //  simu.addEvenement(deplacer11);
        //
        // //  EvementDeverserEau vide2 = new EvementDeverserEau(300, simu.donnees.GetRobots()[0], );
        //
        // //  vide2.execute();
        //
        //   Case voisine2 = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[1].GetLigne() + simu.donnees.GetRobots()[1].GetColonne() -1];
        //   Evenementdeplacement deplacer2 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[1], voisine2);
        //   simu.addEvenement(deplacer2);
        //
        //   Case voisine3 = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[2].GetLigne() + simu.donnees.GetRobots()[2].GetColonne() -1];
        //   Evenementdeplacement deplacer3 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[2], voisine3);
        //   simu.addEvenement(deplacer3);
        //
        //   Case voisine4 = simu.donnees.GetCarte().GetTableauDeCases()[8*simu.donnees.GetRobots()[1].GetLigne() + simu.donnees.GetRobots()[1].GetColonne() -2];
        //   Evenementdeplacement deplacer4 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[1], voisine4);
        //   simu.addEvenement(deplacer4);
        //
        //   Case voisine5 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[1].GetLigne()-1) + simu.donnees.GetRobots()[1].GetColonne() -1];
        //   Evenementdeplacement deplacer5 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[1], voisine5);
        //   simu.addEvenement(deplacer5);
        //
        //   Case voisine6 = simu.donnees.GetCarte().GetTableauDeCases()[8*(simu.donnees.GetRobots()[2].GetLigne()-1) + simu.donnees.GetRobots()[2].GetColonne() -1];
        //   Evenementdeplacement deplacer6 = new Evenementdeplacement(simu, simu.donnees.GetRobots()[2], voisine6);
        //   simu.addEvenement(deplacer6);

        }

        // Partie levée d'exception
        catch (FileNotFoundException e) {
          System.out.println("fichier " + args[0] + " inconnu ou illisible");
        } catch (DataFormatException e) {
          System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
        }





    }

}
