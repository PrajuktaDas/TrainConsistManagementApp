import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC2: Passenger bogies using ArrayList
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nPassenger Bogies:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("After removing AC Chair:");
        System.out.println(passengerBogies);

        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the train.");
        }

        // UC3: Unique Bogie IDs using HashSet
        System.out.println("\n=== Tracking Unique Bogie IDs ===");

        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate

        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIDs);

        // UC4: Ordered Train Consist using LinkedList
        System.out.println("\n=== Ordered Train Consist ===");

        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry Car");
        System.out.println("After adding Pantry Car:");
        System.out.println(trainConsist);

        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("Final Train Consist:");
        System.out.println(trainConsist);

        // UC5: Preserve insertion order using LinkedHashSet
        System.out.println("\n=== Train Formation using LinkedHashSet ===");

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // duplicate attempt

        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);

        System.out.println("\nProgram continues...");
    }
}