import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String [] names = getNames();

    }

    private static String [] getNames() {
        final String exit_code = "-quit";
        ArrayList<String> names = new ArrayList<>();
        boolean isRunning = true;


        System.out.println("Enter names seperated by enter.");
        System.out.println("To exit type: " + exit_code);

        while(isRunning) {
            String name = scanner.nextLine();

            if ( exit_code.equals(name) || "".equals(name) ) {
                isRunning=false;
            }
            else {
                names.add(name);
            }
        }

        return names.toArray(new String[0]);
    }

    private String [] [] generateBlankMatrix(int no) {
        return null;
    }

    private String [] [] groupByNumberOfGroups(int no, String [] names)
    {
        return null;
    }

    private String [] [] groupByGroupMembers(int no, String [] names)
    {
        return null;
    }

    private void prettyPrint(String [] [] names)
    {

    }
}