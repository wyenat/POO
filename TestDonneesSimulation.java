import io.*;

public class TestDonneesSimulation{

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntaxe: java TestDonneesSimulation <nomDeFichier>");
            System.exit(1);
        }
        try {
            DonneesSimulation donneesSimulation = DonneesSimulation(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("fichier " + args[0] + " inconnu ou illisible");
        } catch (DataFormatException e) {
            System.out.println("\n\t**format du fichier " + args[0] + " invalide: " + e.getMessage());
        }
    }

}
