

import io.*;

public class TestRobot {

    public static void main(String[] args) {
        Robot BOB = new Robot(0, 0 ,10);
        Robot Vivien = new Robotdrone(0, 0 ,10);
        Robot Lucille = new Robotapattes(0, 0 ,10);
        Robot Enguerran = new Robotachenilles(0, 0 ,10);
        Robot Roux = new Robotaroues(0, 0 ,10);
        System.out.println(BOB.GetLigne());
        System.out.println(Vivien.GetLigne());
        System.out.println(Lucille.GetLigne());
        System.out.println(Enguerran.GetLigne());
    }

}
