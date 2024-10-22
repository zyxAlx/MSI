package ace.proiecte;

public class ValidareAutovehicul {
    public static boolean valideazaNumarInmatriculare(String numar) {
        return numar.matches("[A-Z]{1,2}[0-9]{2,3}[A-Z]{1,3}");
    }

    public static boolean valideazaCilindree(int cilindree) {
        return cilindree > 0;
    }
}
