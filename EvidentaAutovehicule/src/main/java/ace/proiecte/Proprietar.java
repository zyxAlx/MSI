package ace.proiecte;

public class Proprietar {
    private String nume;
    private String prenume;
    private String cnp;

    public Proprietar(String nume, String prenume, String cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    // Getters și setters
    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return nume + " " + prenume + ", CNP: " + cnp;
    }
}
