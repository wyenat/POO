import io.DonneesSimulation;

public class TestDonneesSimulation{

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntaxe: java TestDonneesSimulation <nomDeFichier>");
            System.exit(1);
        }
        DonneesSimulation donneesSimulation;
        donneesSimulation = RecupererDonnees(args[0]);
        System.out.println(donneesSimulation.GetCarte().ToString());
    }
}
