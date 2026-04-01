import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistManagementApp.InvalidCapacityException {

        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {

        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {

        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC Chair", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {

        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -5)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagementApp.InvalidCapacityException {

        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);

        assertEquals("AC Chair", bogie.getType());
        assertEquals(56, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistManagementApp.InvalidCapacityException {

        TrainConsistManagementApp.PassengerBogie b1 =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        TrainConsistManagementApp.PassengerBogie b2 =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);

        TrainConsistManagementApp.PassengerBogie b3 =
                new TrainConsistManagementApp.PassengerBogie("First Class", 24);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}