package ace.proiecte;

import java.util.ArrayList;
import java.util.List;

public class VehicleAdministrator {
    private List<Vehicle> autovehicule;

    public VehicleAdministrator() {
        this.autovehicule = new ArrayList<>();
    }

    // adaugam vehiculul in gestiunea curenta
    public void inmatriculareAutovehicul(Vehicle vehicle, RegisterVehicle registerVehicle) {
        autovehicule.add(vehicle);
        System.out.println("Autovehiculul a fost înmatriculat: " + vehicle);
        System.out.println("Detalii înmatriculare: " + registerVehicle);
    }

    // Căutare autovehicul după numărul de înmatriculare
    public Vehicle cautaDupaNumar(String numarInmatriculare) {
        for (Vehicle auto : autovehicule) {
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
        for (Vehicle auto : autovehicule) {
            System.out.println(auto);
        }
    }

    public List<Vehicle> getAutovehicule() {
        return autovehicule;
    }
}

