public class TrainConsistManagementApp {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie Class
    static class GoodsBogie {

        String shape;
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Cargo assignment method
        public void assignCargo(String cargo) {

            try {

                // Safety validation
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment: Petroleum cannot be loaded in Rectangular bogie");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo + " -> " + shape + " bogie");

            } catch (CargoSafetyException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                System.out.println("Cargo assignment attempt completed.\n");
            }
        }

        public String getCargo() {
            return cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===\n");

        // Create bogies
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");

        // Safe assignment
        cylindrical.assignCargo("Petroleum");

        // Unsafe assignment
        rectangular.assignCargo("Petroleum");

        // Program continues
        System.out.println("Program continues after handling exception.");
    }
}