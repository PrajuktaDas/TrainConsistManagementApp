import java.util.Arrays;

public class TrainConsistManagementApp {

    // Method to sort bogie names
    public static String[] sortBogieNames(String[] bogies) {

        Arrays.sort(bogies);
        return bogies;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("\nOriginal Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nProgram continues...");
    }
}