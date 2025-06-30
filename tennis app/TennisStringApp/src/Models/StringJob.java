package Models;

public class StringJob {
    String mains;
    String cross;
    // True means hybrid ( two different strings for the mains and crosses ), otherwise false means full bed
    boolean isHybrid;
    boolean splitTension;

    // if splitTension is true, then tension is avg, otherwise all the tensions will be the same
    double tensionMain;
    double tensionCross;
    double tension;

    String typeMain;
    String typeCross;

}
