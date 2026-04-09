import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {

        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {

        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {

        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {

        TrainConsistManagementApp.GoodsBogie b1 =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        TrainConsistManagementApp.GoodsBogie b2 =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum"); // unsafe
        b2.assignCargo("Grain");     // safe

        assertEquals("Grain", b2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {

        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}