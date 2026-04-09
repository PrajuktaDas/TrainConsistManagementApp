import java.util.Arrays;

public class TrainConsistManagementApp {

    // Linear Search Method
    public static boolean searchBogie(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(key)) {
                return true; // match found
            }

        }

        return false; // no match found
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        System.out.println("\nAvailable Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        String searchKey = "BG309";

        boolean found = searchBogie(bogieIds, searchKey);

        if(found) {
            System.out.println("\nBogie ID " + searchKey + " found in train consist.");
        } else {
            System.out.println("\nBogie ID " + searchKey + " not found.");
        }

        System.out.println("\nProgram continues...");
    }
}