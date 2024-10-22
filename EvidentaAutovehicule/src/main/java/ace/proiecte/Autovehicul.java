package ace.proiecte;

public class Autovehicul {
    private String tip;
    private String marca;
    private int cilindree;
    private String culoare;
    private RevizieTehnica revizieTehnica;
    private Proprietar proprietar;
    private Inmatriculare inmatriculare;



    public Autovehicul(String tip, String marca, int cilindree, String culoare, Proprietar proprietar, Inmatriculare inmatriculare) {
        this.tip = tip;
        this.marca = marca;
        this.cilindree = cilindree;
        this.culoare = culoare;
        this.proprietar=proprietar;
        this.inmatriculare= inmatriculare;
        this.revizieTehnica = null;  // la fabricare  are revizie tehnică
    }
    public Inmatriculare getInmatriculare() {
        return inmatriculare;
    }

    public void setInmatriculare(Inmatriculare inmatriculare) {
        this.inmatriculare = inmatriculare;
    }
    public Proprietar getProprietar() {
        return proprietar;
    }

    public void setProprietar(Proprietar proprietar) {
        this.proprietar = proprietar;
    }

    public void setRevizieTehnica(RevizieTehnica revizieTehnica) {
        this.revizieTehnica = revizieTehnica;
    }

    public RevizieTehnica getRevizieTehnica() {
        return revizieTehnica;
    }
    public String getTip() {
        return tip;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindree() {
        return cilindree;
    }

    public String getCuloare() {
        return culoare;
    }

    @Override
    public String toString() {
        return "Autovehicul{" +
                "tip='" + tip + '\'' +
                ", marca='" + marca + '\'' +
                ", cilindree=" + cilindree +
                ", culoare='" + culoare + '\'' +
                '}';
    }
}
