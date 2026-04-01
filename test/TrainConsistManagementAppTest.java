import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private List<Bogie> createBogies() {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 65));

        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {

        List<Bogie> result =
                TrainConsistManagementApp.filterUsingLoop(createBogies());

        for (Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testStreamFilteringLogic() {

        List<Bogie> result =
                TrainConsistManagementApp.filterUsingStream(createBogies());

        for (Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<Bogie> loopResult =
                TrainConsistManagementApp.filterUsingLoop(createBogies());

        List<Bogie> streamResult =
                TrainConsistManagementApp.filterUsingStream(createBogies());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {

        List<Bogie> bogies = createBogies();

        long start = System.nanoTime();
        TrainConsistManagementApp.filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<Bogie> largeList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            largeList.add(new Bogie("Sleeper", 72));
            largeList.add(new Bogie("AC Chair", 56));
        }

        List<Bogie> result =
                TrainConsistManagementApp.filterUsingStream(largeList);

        assertTrue(result.size() > 0);
    }
}