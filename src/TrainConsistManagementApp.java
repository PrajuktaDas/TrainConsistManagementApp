import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

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

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the train.");
        }

        System.out.println("\nFinal Passenger Bogie List:");
        System.out.println(passengerBogies);


        // UC3: Unique Bogie IDs using HashSet
        System.out.println("\n=== Tracking Unique Bogie IDs ===");

        Set<String> bogieIDs = new HashSet<>();

        // Adding bogie IDs (including duplicates intentionally)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs in the train:");
        System.out.println(bogieIDs);

        System.out.println("\nProgram continues...");
    }
}