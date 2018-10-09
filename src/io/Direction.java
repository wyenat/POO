package io;

public enum Direction {
    NORD ("NORD", "N", "Nord"),
    EST ("EST", "E", "Est"),
    SUD ("SUD", "S", "Sud"),
    OUEST ("OUEST", "O", "W", "Ouest");

    private String name = "";

    Direction(String nom){
        this.name = nom;
    }

    public String ToString(){
        return name;
    }
}
