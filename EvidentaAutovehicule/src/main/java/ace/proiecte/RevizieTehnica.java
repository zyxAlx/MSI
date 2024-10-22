package ace.proiecte;

public class RevizieTehnica {
    private String dataReviziei;

    public RevizieTehnica(String dataReviziei) {
        this.dataReviziei = dataReviziei;
    }

    public String getDataReviziei() {
        return dataReviziei;
    }

    public void setDataReviziei(String dataReviziei) {
        this.dataReviziei = dataReviziei;
    }

    @Override
    public String toString() {
        return "RevizieTehnica{" +
                "dataReviziei='" + dataReviziei + '\'' +
                '}';
    }
}
