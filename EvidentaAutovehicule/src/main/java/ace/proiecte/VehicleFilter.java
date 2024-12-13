package ace.proiecte;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleFilter {
    public static List<Vehicle> filtreazaDupaDataRevizie(List<Vehicle> autovehicule, String data) {
        return autovehicule.stream()
                .filter(auto -> auto.getRevizieTehnica() != null && auto.getRevizieTehnica().getDataReviziei().compareTo(data) < 0)
                .collect(Collectors.toList());
    }
}