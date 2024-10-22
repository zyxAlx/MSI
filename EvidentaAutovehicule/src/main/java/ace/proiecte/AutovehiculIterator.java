package ace.proiecte;

import java.util.Iterator;
import java.util.List;

public class AutovehiculIterator implements Iterator<Autovehicul> {
    private List<Autovehicul> autovehicule;
    private int pozitie;

    public AutovehiculIterator(List<Autovehicul> autovehicule) {
        this.autovehicule = autovehicule;
        this.pozitie = 0;
    }

    @Override
    public boolean hasNext() {
        return pozitie < autovehicule.size();
    }

    @Override
    public Autovehicul next() {
        return autovehicule.get(pozitie++);
    }
}
