package ace.proiecte;

import java.util.HashSet;
import java.util.Set;

public class NumarInmatriculareGenerator {
    private Set<String> numereGenerate;

    public NumarInmatriculareGenerator() {
        this.numereGenerate = new HashSet<>();
    }

    public String genereazaNumarUnic() {
        String numar;
        do {
            numar = "B" + (int)(Math.random() * 900 + 100) + "ALX";
        } while (numereGenerate.contains(numar));

        numereGenerate.add(numar);
        return numar;
    }
}
