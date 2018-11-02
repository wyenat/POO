
import io.*;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class TestLecteurDonnees {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntaxe: java TestLecteurDonnees <nomDeFichier>");
            System.exit(1);
        }
        try {
            Simulateur simu = new Simulateur(LecteurDonnees.lire(args[0]));
            Robot aDeplacer = simu.donnees.GetRobots()[0];
            long dateFin = (long) simu.donnees.GetCarte().GetTailleCases()/ (long) aDeplacer.GetVitesse();
            Case voisine = simu.donnees.GetCarte().GetTableauDeCases()[3*8+4];
            Evenementdeplacement deplacer = new Evenementdeplacement(dateFin, aDeplacer, voisine);
            System.out.println("Date fin = " + dateFin);
            simu.addEvenement(deplacer);
        } 
        
        // Partie levée d'exception
        catch (FileNotFoundException e) {
            System.out.println("fichier " + args[0] + " inconnu ou illisible");
        } catch (DataFormatException e) {
            System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
        }
    }

}
