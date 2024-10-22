package ace.proiecte;

import java.util.List;

public class RaportAutovehicule {
    public static void genereazaRaport(List<Autovehicul> autovehicule) {
        System.out.println("Raport autovehicule înmatriculate:");
        for (Autovehicul auto : autovehicule) {
            System.out.println(auto);
        }
    }
}
