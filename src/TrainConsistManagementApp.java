import java.util.Arrays;

public class TrainConsistManagementApp {

    // Binary Search Method
    public static boolean binarySearchBogie(String[] bogieIds, String key) {

        if (bogieIds.length == 0) {
            return false;
        }

        // Ensure array is sorted
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true; // Found
            }
            else if (comparison < 0) {
                low = mid + 1; // Search right half
            }
            else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};

        String searchKey = "BG205";

        boolean found = binarySearchBogie(bogieIds, searchKey);

        if(found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }

        System.out.println("Program continues...");
    }
}