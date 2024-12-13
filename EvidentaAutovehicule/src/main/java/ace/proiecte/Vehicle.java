package ace.proiecte;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private String tip;
    private String marca;
    private int cilindree;
    private String culoare;
    private RevizieTehnica revizieTehnica;
    private Proprietar proprietar;
    private RegisterVehicle registerVehicle;

    public Vehicle(String tip, String marca, int cilindree, String culoare, Proprietar proprietar, RegisterVehicle registerVehicle) {
        this.tip = tip;
        this.marca = marca;
        this.cilindree = cilindree;
        this.culoare = culoare;
        this.proprietar = proprietar;
        this.registerVehicle = registerVehicle;
        this.revizieTehnica = null; // la fabricare, nu are revizie tehnica
    }

    public RegisterVehicle getInmatriculare() {
        return registerVehicle;
    }

    public void setInmatriculare(RegisterVehicle registerVehicle) {
        this.registerVehicle = registerVehicle;
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
