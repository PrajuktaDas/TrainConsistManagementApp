import java.util.ArrayList;
import java.util.List;

class GoodsBogie {

    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " Bogie carrying " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {

        return bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = checkSafetyCompliance(bogies);

        System.out.println("\nGoods Bogies:");
        bogies.forEach(System.out::println);

        if (isSafe) {
            System.out.println("\nTrain formation is SAFETY COMPLIANT");
        } else {
            System.out.println("\nTrain formation is NOT SAFE");
        }

        System.out.println("\nProgram continues...");
    }
}