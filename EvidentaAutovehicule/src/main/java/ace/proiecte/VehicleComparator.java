package ace.proiecte;

import java.util.Comparator;

public class VehicleComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle a1, Vehicle a2) {
        return a1.getTip().compareTo(a2.getTip());
    }
}

