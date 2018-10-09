package io;


import java.io.*;
import java.util.*;
import java.util.zip.DataFormatException;
import io.Carte;


/**
 * Lecteur de cartes au format spectifié dans le sujet.
 * Les données sur les cases, robots puis incendies sont lues dans le fichier,
 * puis simplement affichées.
 * A noter: pas de vérification sémantique sur les valeurs numériques lues.
 *
 * IMPORTANT:
 *
 * Cette classe ne fait que LIRE les infos et les afficher.
 * A vous de modifier ou d'ajouter des méthodes, inspirées de celles présentes
 * (ou non), qui CREENT les objets au moment adéquat pour construire une
 * instance de la classe DonneesSimulation à partir d'un fichier.
 *
 * Vous pouvez par exemple ajouter une méthode qui crée et retourne un objet
 * contenant toutes les données lues:
 *    public static DonneesSimulation creeDonnees(String fichierDonnees);
 * Et faire des méthode creeCase(), creeRobot(), ... qui lisent les données,
 * créent les objets adéquats et les ajoutent ds l'instance de
 * DonneesSimulation.
 */
public class LecteurDonnees {


    /**
     * Lit et affiche le contenu d'un fichier de donnees (cases,
     * robots et incendies).
     * Ceci est méthode de classe; utilisation:
     * LecteurDonnees.lire(fichierDonnees)
     * @param fichierDonnees nom du fichier à lire
     */
    public static void lire(String fichierDonnees)
        throws FileNotFoundException, DataFormatException {
        System.out.println("\n == Lecture du fichier" + fichierDonnees);
        LecteurDonnees lecteur = new LecteurDonnees(fichierDonnees);
        Carte carte = lecteur.lireCarte();
        System.out.println(carte.ToString());
        Incendie incendies[];
        incendies = lecteur.lireIncendies();
        AfficherIncendies(incendies);
        Robot robots[];
        robots = lecteur.lireRobots();
        AfficherRobots(robots);
        scanner.close();
        System.out.println("\n == Lecture terminee");
    }




    // Tout le reste de la classe est prive!

    private static void AfficherIncendies(Incendie[] incendies){
        /**
         * Affiche les incendies
         */
         System.out.println("\n\t#Incendies");
         for (int i=0; i<incendies.length; i++){
             System.out.println("Incendie " + i + ": Position : (" + incendies[i].GetLigne()
                    + "," + incendies[i].GetColonne() + ")\tIntensité : "
                    + incendies[i].GetIntensite());
         }
    }

    private static void AfficherRobots(Robot[] robots){
        /**
         * Affiche les robots
         */
         System.out.println("\n\t#Robots");
         for (int i=0; i<robots.length; i++){
             System.out.println("Robot " + i + ": Position : (" + robots[i].GetLigne()
                    + "," + robots[i].GetColonne() + ")\t type : " + robots[i].GetType()
                    + "\t Vitesse : " + robots[i].GetVitesse());
         }
    }

    private static Scanner scanner;

    /**
     * Constructeur prive; impossible d'instancier la classe depuis l'exterieur
     * @param fichierDonnees nom du fichier a lire
     */
    private LecteurDonnees(String fichierDonnees)
        throws FileNotFoundException {
        scanner = new Scanner(new File(fichierDonnees));
        scanner.useLocale(Locale.US);
    }

    /**
     * Lit et affiche les donnees de la carte.
     * @throws ExceptionFormatDonnees
     */
    private Carte lireCarte() throws DataFormatException {
        ignorerCommentaires();
        try {
            int nbLignes = scanner.nextInt();
            int nbColonnes = scanner.nextInt();
            int tailleCases = scanner.nextInt();	// en m
            Case cases[];
            cases = new Case[nbLignes*nbColonnes];
            // System.out.println("Carte " + nbLignes + "x" + nbColonnes
                    // + "; taille des cases = " + tailleCases);

                    for (int lig = 0; lig < nbLignes; lig++) {
                        for (int col = 0; col < nbColonnes; col++) {
                        cases[lig*nbColonnes + col] = this.lireCase(lig, col);
                        }
            }
            Carte carte = new Carte(tailleCases, nbLignes, nbColonnes, cases);
            return carte;

        } catch (NoSuchElementException e) {
            throw new DataFormatException("Format invalide. "
                    + "Attendu: nbLignes nbColonnes tailleCases");
        }
        // une ExceptionFormat levee depuis lireCase est remontee telle quelle
    }




    /**
     * Lit et affiche les donnees d'une case.
     */
    private Case lireCase(int lig, int col) throws DataFormatException {
        ignorerCommentaires();
        // System.out.print("Case (" + lig + "," + col + "): ");
        String chaineNature = new String();
        NatureTerrain nature;

        try {
            chaineNature = scanner.next();
            // si NatureTerrain est un Enum, vous pouvez recuperer la valeur
            // de l'enum a partir d'une String avec:
            nature = NatureTerrain.valueOf(chaineNature);

            verifieLigneTerminee();

            // System.out.print("nature = " + chaineNature);

        } catch (NoSuchElementException e) {
            throw new DataFormatException("format de case invalide. "
                    + "Attendu: nature altitude [valeur_specifique]");
        }
        Case caseActive = new Case(lig, col, nature);
        // System.out.println();
        return caseActive;
    }


    /**
     * Lit et affiche les donnees des incendies.
     */
    private Incendie[] lireIncendies() throws DataFormatException {
        ignorerCommentaires();
        try {
            int nbIncendies = scanner.nextInt();
            if (nbIncendies <= 0){
                throw new IllegalArgumentException("Il n'y a pas le feu en fait...");
            }
            Incendie incendies[];
            incendies = new Incendie[nbIncendies];

            // System.out.println("Nb d'incendies = " + nbIncendies);
            for (int i = 0; i < nbIncendies; i++) {
                incendies[i] = lireIncendie(i);
            }
            return incendies;

        } catch (NoSuchElementException e) {
            throw new DataFormatException("Format invalide. "
                    + "Attendu: nbIncendies");
        }
    }


    /**
     * Lit et affiche les donnees du i-eme incendie.
     * @param i
     */
    private Incendie lireIncendie(int i) throws DataFormatException {
        ignorerCommentaires();
        // System.out.print("Incendie " + i + ": ");

        try {
            int lig = scanner.nextInt();
            int col = scanner.nextInt();
            int intensite = scanner.nextInt();
            if (intensite <= 0) {
                throw new DataFormatException("incendie " + i
                        + "nb litres pour eteindre doit etre > 0");
            }
            verifieLigneTerminee();

            // System.out.println("position = (" + lig + "," + col
                    // + ");\t intensite = " + intensite);
            Incendie incendie = new Incendie(lig, col, intensite);
            return incendie;

        } catch (NoSuchElementException e) {
            throw new DataFormatException("format d'incendie invalide. "
                    + "Attendu: ligne colonne intensite");
        }
    }


    /**
     * Lit et affiche les donnees des robots.
     */
    private Robot[] lireRobots() throws DataFormatException {
        ignorerCommentaires();
        try {
            int nbRobots = scanner.nextInt();
            if (nbRobots <= 0){
                throw new IllegalArgumentException("Il n'y a pas de robots en fait...");
            }
            Robot robots[];
            robots = new Robot[nbRobots];
            // System.out.println("Nb de robots = " + nbRobots);
            for (int i = 0; i < nbRobots; i++) {
                robots[i] = lireRobot(i);
            }
            return robots;

        } catch (NoSuchElementException e) {
            throw new DataFormatException("Format invalide. "
                    + "Attendu: nbRobots");
        }
    }


    /**
     * Lit et affiche les donnees du i-eme robot.
     * @param i
     */
    private Robot lireRobot(int i) throws DataFormatException {
        ignorerCommentaires();
        // System.out.print("Robot " + i + ": ");

        try {
            int lig = scanner.nextInt();
            int col = scanner.nextInt();
            // System.out.print("position = (" + lig + "," + col + ");");
            String type = scanner.next();

            // System.out.print("\t type = " + type);


            // lecture eventuelle d'une vitesse du robot (entier)
            // System.out.print("; \t vitesse = ");
            String s = scanner.findInLine("(\\d+)");	// 1 or more digit(s) ?
            // pour lire un flottant:    ("(\\d+(\\.\\d+)?)");
            int vitesse;
            TypeRobot typeRobot = TypeRobot.valueOf(type);
            if (s == null) {
                vitesse = VitesseDefaut(typeRobot);
            } else {
                vitesse = Integer.parseInt(s);
                // System.out.print(vitesse);
            }
            verifieLigneTerminee();
            Robot robot = new Robot(typeRobot, lig, col, vitesse);
            return robot;
            // System.out.println();
        } catch (NoSuchElementException e) {
            throw new DataFormatException("format de robot invalide. "
                    + "Attendu: ligne colonne type [valeur_specifique]");
        }
    }

private static int VitesseDefaut(TypeRobot type){
    /**
     * Renvoie la vitesse par défaut du robot si elle n'est pas
     * précisée dans le .map
     */
     int vitesseDefaut;
     System.out.println(type);
     switch(type){
        case CHENILLES:
            vitesseDefaut = 60;
            break;
        case ROUES:
            vitesseDefaut = 80;
            break;
        case PATTES:
            vitesseDefaut = 30;
            break;
        case DRONE:
            vitesseDefaut = 100;
            break;
        default:
            vitesseDefaut = 0;
    }
    return vitesseDefaut;
}


    /** Ignore toute (fin de) ligne commencant par '#' */
    private void ignorerCommentaires() {
        while(scanner.hasNext("#.*")) {
            scanner.nextLine();
        }
    }

    /**
     * Verifie qu'il n'y a plus rien a lire sur cette ligne (int ou float).
     * @throws ExceptionFormatDonnees
     */
    private void verifieLigneTerminee() throws DataFormatException {
        if (scanner.findInLine("(\\d+)") != null) {
            throw new DataFormatException("format invalide, donnees en trop.");
        }
    }
}
