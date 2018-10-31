
import io.*;

public class TestEvenement {

    public static void main(String[] args) {
        Robot Lucille = new Robot(0, 0 ,10);
        Robot Vivien = new Robotdrone(0, 0 ,10);
        Case C = new Case(12, 12, EAU);
        Evenementdeplacement Deplacer = new Evenementdeplacement(14, Vivien, C);
        Deplacer.execute();
        System.out.println(Lucille.GetLigne());
        System.out.println(Vivien.GetLigne());
    }

}
