package ace.proiecte;

public class Main {
    public static void main(String[] args) {
        // Creează un obiect GestorAutovehicule
        VehicleAdministrator admin = new VehicleAdministrator();

        // Creează și deschide interfața grafică
        new GraphicalInterface(admin);
    }
}