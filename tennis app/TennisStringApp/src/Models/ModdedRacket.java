package Models;

public class ModdedRacket extends Racket {
    StringJob currentStringJob;
    StringJob [] previousStringJob;

    String underGrip;
    String overGrip;
    String typeOvergrip;
    boolean isLeatherUnderGrip;

    String [] otherMods;

    Weight[] weights;
}

class Weight {
    double grams;
    String [] locations;
    String metal;
    boolean onHoop;
}
