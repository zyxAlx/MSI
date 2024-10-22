package ace.proiecte;

import java.util.List;
import java.util.stream.Collectors;

public class FiltruAutovehicule {
    public static List<Autovehicul> filtreazaDupaDataRevizie(List<Autovehicul> autovehicule, String data) {
        return autovehicule.stream()
                .filter(auto -> auto.getRevizieTehnica() != null && auto.getRevizieTehnica().getDataReviziei().compareTo(data) < 0)
                .collect(Collectors.toList());
    }
}