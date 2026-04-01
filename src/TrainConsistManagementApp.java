import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // Custom Exception (Nested Class)
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie Class (Nested Class)
    static class PassengerBogie {

        String type;
        int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }

            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " - Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {

            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));
            bogies.add(new PassengerBogie("First Class", 24));

            System.out.println("\nPassenger Bogies Created:");

            for (PassengerBogie b : bogies) {
                System.out.println(b);
            }

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues...");
    }
}