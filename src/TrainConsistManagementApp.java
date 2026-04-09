import java.util.Arrays;

public class TrainConsistManagementApp {

    // Bubble Sort Method
    public static int[] sortCapacities(int[] capacities) {

        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {

                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                }
            }
        }

        return capacities;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("\nOriginal Capacities:");
        System.out.println(Arrays.toString(capacities));

        // Sorting using Bubble Sort
        sortCapacities(capacities);

        System.out.println("\nSorted Capacities:");
        System.out.println(Arrays.toString(capacities));

        System.out.println("\nProgram continues...");
    }
}