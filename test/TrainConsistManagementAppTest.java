import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 60));

        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {

        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(282, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {

        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {

        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {

        Bogie bogie = new Bogie("Sleeper", 72);

        assertEquals(72, bogie.capacity);
    }

    @Test
    void testReduce_AllBogiesIncluded() {

        List<Bogie> bogies = createSampleBogies();

        int expected = 72 + 56 + 70 + 24 + 60;

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(expected, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {

        List<Bogie> bogies = createSampleBogies();
        int originalSize = bogies.size();

        bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
    }
}