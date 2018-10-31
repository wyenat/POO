
import io.*;
import io.NatureTerrain;

public class TestEvenement {

    public static void main(String[] args) {
        Robot Lucille = new Robot(0, 0 ,10);
        Robot Vivien = new Robotdrone(0, 0 ,10);
        NatureTerrain nature;
        String mmnature = "EAU";
        nature = NatureTerrain.valueOf(mmnature);
        Case C = new Case(12, 12, nature);
        Evenementdeplacement Deplacer = new Evenementdeplacement(14, Vivien, C);
        Deplacer.execute();
        System.out.println(Lucille.GetLigne());
        System.out.println(Vivien.GetLigne());
    }

}
