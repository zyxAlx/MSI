    package ace.proiecte;

    import java.util.ArrayList;
    import java.util.List;


    public class CautareAutovehicul {

        public static List<Vehicle> cautaDupaProprietar(List<Vehicle> autovehicule, String numeProprietar)
                throws NullVehicleListException {
            // Verificăm dacă lista este null sau goală
            if (autovehicule == null || autovehicule.isEmpty()) {
                throw new NullVehicleListException("Lista de autovehicule este null sau goală.");
            }

            List<Vehicle> autovehiculeGasite = new ArrayList<>();
            VehicleIterator iterator = new VehicleIterator(autovehicule); // Inițializăm iteratorul

            while (iterator.hasNext()) { // Verificăm dacă mai există elemente
                Vehicle auto = iterator.next(); // Luăm următorul autovehicul

                // Verificăm dacă autovehiculul are un proprietar și dacă numele acestuia corespunde
                if (auto.getProprietar() != null && auto.getProprietar().getNume().equalsIgnoreCase(numeProprietar)) {
                    autovehiculeGasite.add(auto); // Adăugăm autovehiculul în lista rezultatelor
                }
            }

            return autovehiculeGasite; // Returnăm lista cu autovehiculele găsite
        }
    }