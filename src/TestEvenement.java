import io.*;

public class TestEvenement {

    public static void main(String[] args) {

        Robotaroues Lucille = new Robotaroues(0, 0, 10);
        Robot Vivien = new Robotdrone(0, 0, 10);
        NatureTerrain nature;
        String mmnature = "EAU";
        nature = NatureTerrain.valueOf(mmnature);
        Case C = new Case(12, 12, nature);
        Evenementdeplacement Deplacer = new Evenementdeplacement(14, Vivien, C);
        Deplacer.deplacement(Vivien, C);
        Incendie I = new Incendie(0, 0, 1000);
        EvenementviderReservoir vide = new EvenementviderReservoir(1, Vivien, I);

        System.out.println("Intensité de l'incendie avant l'éxécution de l'evenement");
        System.out.println(I.GetIntensite());
        System.out.println("Reservoir de Vivien avant");
        System.out.println(Vivien.getReservoir());

        vide.execute();

        System.out.println("Intensité de l'incendie apres l'éxécution de l'evenement");
        System.out.println(I.GetIntensite());
        System.out.println("Reservoir de Vivien apres");
        System.out.println(Vivien.getReservoir());
    }

}
