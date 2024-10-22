package ace.proiecte;

import java.util.ArrayList;
import java.util.List;

public class CautareAutovehicul {

    public static List<Autovehicul> cautaDupaProprietar(List<Autovehicul> autovehicule, String numeProprietar) {
        List<Autovehicul> autovehiculeGasite = new ArrayList<>();


        for (Autovehicul auto : autovehicule) {
            // verificăm dacă autovehiculul are un proprietar și dacă numele acestuia corespunde cu cel căutat
            if (auto.getProprietar() != null && auto.getProprietar().getNume().equalsIgnoreCase(numeProprietar)) {
                autovehiculeGasite.add(auto);  // adăugăm autovehiculul în lista rezultatelor
            }
        }

        return autovehiculeGasite;  // returnăm lista cu autovehiculele găsite
    }
}
