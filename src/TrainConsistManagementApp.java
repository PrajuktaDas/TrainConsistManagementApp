import java.util.Arrays;

public class TrainConsistManagementApp {

    // Search with validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train consist.");
        }

        // Ensure sorted order before Binary Search
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true;
            }
            else if (comparison < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogieIds = {"BG101","BG205","BG309"};

        String searchKey = "BG205";

        try {

            boolean found = searchBogie(bogieIds, searchKey);

            if(found) {
                System.out.println("Bogie ID " + searchKey + " found.");
            }
            else {
                System.out.println("Bogie ID " + searchKey + " not found.");
            }

        } catch (IllegalStateException e) {

            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("Program continues...");
    }
}