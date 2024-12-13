package ace.proiecte;

import java.io.Serializable;

public class RegisterVehicle implements Serializable {
    private String numarInmatriculare;
    private String dataInmatricularii;
    private transient RegistrationNumberGenerator registrationNumberGenerator = new RegistrationNumberGenerator(); // transient pentru a nu serializa

    public RegisterVehicle(String dataInmatricularii) {
        this.numarInmatriculare = registrationNumberGenerator.genereazaNumarUnic();
        this.dataInmatricularii = dataInmatricularii;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public String getDataInmatricularii() {
        return dataInmatricularii;
    }

    @Override
    public String toString() {
        return "Inmatriculare{" +
                "numarInmatriculare='" + numarInmatriculare + '\'' +
                ", dataInmatricularii='" + dataInmatricularii + '\'' +
                '}';
    }
}