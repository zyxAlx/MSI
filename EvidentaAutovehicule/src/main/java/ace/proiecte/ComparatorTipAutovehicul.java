package ace.proiecte;

import java.util.Comparator;

public class ComparatorTipAutovehicul implements Comparator<Autovehicul> {
    @Override
    public int compare(Autovehicul a1, Autovehicul a2) {
        return a1.getTip().compareTo(a2.getTip());
    }
}

