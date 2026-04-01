import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {

    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {

        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {

        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 65));

        // LOOP PERFORMANCE
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long endLoop = System.nanoTime();

        long loopTime = endLoop - startLoop;

        // STREAM PERFORMANCE
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long endStream = System.nanoTime();

        long streamTime = endStream - startStream;

        System.out.println("\nLoop Filtering Result:");
        loopResult.forEach(System.out::println);
        System.out.println("Loop Execution Time: " + loopTime + " ns");

        System.out.println("\nStream Filtering Result:");
        streamResult.forEach(System.out::println);
        System.out.println("Stream Execution Time: " + streamTime + " ns");

        System.out.println("\nProgram continues...");
    }
}