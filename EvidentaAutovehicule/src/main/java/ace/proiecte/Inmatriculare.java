package ace.proiecte;

public class Inmatriculare {
    private String numarInmatriculare;
    private String dataInmatricularii;
    private NumarInmatriculareGenerator numarInmatriculareGenerator = new NumarInmatriculareGenerator();

    public Inmatriculare( String dataInmatricularii) {
        this.numarInmatriculare = numarInmatriculareGenerator.genereazaNumarUnic();
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

