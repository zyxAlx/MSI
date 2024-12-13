package ace.proiecte;

import java.util.List;

public class VehicleRaport {
    public static void genereazaRaport(List<Vehicle> autovehicule) {
        System.out.println("Raport autovehicule înmatriculate:");
        for (Vehicle auto : autovehicule) {
            System.out.println(auto);
        }
    }
}
