import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Hello, welcome to a group making app !");
        System.out.println("In this app you start by entering names of you students, and then we will make groups based on:");
        System.out.println("1. No of students per group");
        System.out.println("2. No of total groups");
        System.out.println("Start by entering names below, click enter after each name and type exit code once done.");
        String[] names = getNames();

        System.out.print("Enter Grouping Mode:\n1 -> Group by number of groups.\n2 -> Group by number of group members.\n>> ");
        String mode = scanner.nextLine();


        if (Integer.parseInt(mode) == 1) {
            System.out.print("Enter number of groups >> ");
            int groups = scanner.nextInt();
            prettyPrint(groupByNumberOfGroups(groups, names));
        } else if (Integer.parseInt(mode) == 2) {
            System.out.print("Enter number of groups >> ");
            int groups = scanner.nextInt();
            prettyPrint(groupByGroupMembers(groups, names));
        } else {
            System.out.println("ERROR: The option you have entered is not valid, please rerun the program with a valid grouping mode.");
        }

        scanner.nextLine(); // 👈 flush the newline so the nextLine() below works!
        System.out.print("Would you like to repeat with other grouping mode but same names ? ( please enter y/n only ) >> ");
        String repeat = scanner.nextLine();

        if (repeat.trim().equalsIgnoreCase("y")) {
            if (Integer.parseInt(mode) == 1) {
                System.out.print("Enter number of groups >> ");
                int groups = scanner.nextInt();
                prettyPrint(groupByGroupMembers(groups, names));
            } else if (Integer.parseInt(mode) == 2) {
                System.out.print("Enter number of groups >> ");
                int groups = scanner.nextInt();
                prettyPrint(groupByNumberOfGroups(groups, names));
            }
        }

        System.out.println("Thank you, goodbye.");
    }


    private static String[] getNames() {
        final String exit_code = "-quit";
        ArrayList<String> names = new ArrayList<>();
        boolean isRunning = true;


        System.out.println("Enter names seperated by enter.");
        System.out.println("To exit type: " + exit_code);
        int counter = 1;

        while (isRunning) {
            System.out.print("Enter name " + String.valueOf(counter) + " >> ");
            String name = scanner.nextLine();

            if (exit_code.equals(name) || "".equals(name)) {
                isRunning = false;
            } else {
                names.add(name);
            }

            counter++;
        }

        return names.toArray(new String[0]);
    }

    private static String[][] groupByGroupMembers(int no, String[] names) {
        int noOfGroups = (int) Math.ceil((double) names.length / no);
        String[][] groups = new String[noOfGroups][];
        List<String> namePool = new ArrayList<>(Arrays.asList(names));

        // Initialize arrays dynamically based on remaining names
        for (int i = 0; i < noOfGroups; i++) {
            int groupSize = Math.min(no, namePool.size());
            groups[i] = new String[groupSize];

            for (int j = 0; j < groupSize; j++) {
                int randIndex = random.nextInt(namePool.size());
                String name = namePool.remove(randIndex);
                groups[i][j] = name;
            }
        }

        return groups;
    }

    private static String[][] groupByNumberOfGroups(int no, String[] names) {
        int noOfPeople = (int) Math.floor((double) names.length / no);
        String[][] groups = new String[no+1][noOfPeople];
        List<String> namePool = new ArrayList<>(Arrays.asList(names));

        // Initialize arrays dynamically based on remaining names
        for (int i = 0; i < no; i++) {
            for (int j = 0; j < noOfPeople; j++) {
                if (!namePool.isEmpty()) {
                    int randIndex = random.nextInt(namePool.size());
                    String name = namePool.remove(randIndex);
                    groups[i][j] = name;
                }
            }
        }

        System.out.println(namePool);
        if (!namePool.isEmpty()) {
            groups[no] = namePool.toArray(new String[0]);
        }

        return groups;
    }

    private static String formatPrettyString(String[] names, int idx) {
        StringBuilder formatted = new StringBuilder((idx == -1 ? "Extras: " : "Group " + idx + ": "));
        Iterator<String> formI = Arrays.stream(names).iterator();

        while (formI.hasNext()) {
            String name = formI.next();
            if (name == null) {
                formatted.append("  "); // blank space for null
            } else {
                formatted.append(name).append("  ");
            }
        }

        return formatted.toString();
    }

    private static void prettyPrint(String[][] names) {
        int qt = (names[0] == names[names.length-1]) ? names.length : names.length - 1;

        for (int i = 0; i < qt; i++) {
            System.out.println(formatPrettyString(names[i], i + 1));
        }

        if (!(names[0] == names[names.length-1])) {
            System.out.println(formatPrettyString(names[names.length-1], -1));
        }
    }
}