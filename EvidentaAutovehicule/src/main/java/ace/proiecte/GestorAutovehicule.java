package ace.proiecte;

import java.util.ArrayList;
import java.util.List;

public class GestorAutovehicule {
    private List<Autovehicul> autovehicule;

    public GestorAutovehicule() {
        this.autovehicule = new ArrayList<>();
    }

    // adaugam vehiculul in gestiunea curenta
    public void inmatriculareAutovehicul(Autovehicul autovehicul, Inmatriculare inmatriculare) {
        autovehicule.add(autovehicul);
        System.out.println("Autovehiculul a fost înmatriculat: " + autovehicul);
        System.out.println("Detalii înmatriculare: " + inmatriculare);
    }

    // Căutare autovehicul după numărul de înmatriculare
    public Autovehicul cautaDupaNumar(String numarInmatriculare) {
        for (Autovehicul auto : autovehicule) {
            // Verificăm dacă autovehiculul are detalii de înmatriculare
            if (auto.getInmatriculare().getNumarInmatriculare().equals(numarInmatriculare)) {
                return auto;
            }
        }
        return null;
    }

    // Alte operațiuni cerute...

    // Afișare autovehicule
    public void afiseazaAutovehicule() {
        for (Autovehicul auto : autovehicule) {
            System.out.println(auto);
        }
    }
}

