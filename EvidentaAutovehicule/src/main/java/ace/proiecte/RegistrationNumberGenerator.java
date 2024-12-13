package ace.proiecte;

import java.util.HashSet;
import java.util.Set;

public class RegistrationNumberGenerator {
    private Set<String> generatedPlates;

    public RegistrationNumberGenerator() {
        this.generatedPlates = new HashSet<>();
    }

    public String genereazaNumarUnic() {
        String numar;
        do {
            numar = "B" + (int)(Math.random() * 900 + 100) + "ALX"; // Generează un număr aleatoriu
        } while (!RegisterValidation.valideazaNumarInmatriculare(numar) || generatedPlates.contains(numar)); // Verifică dacă numărul respectă formatul și nu a mai fost generat

        generatedPlates.add(numar); //
        return numar;
    }
}
