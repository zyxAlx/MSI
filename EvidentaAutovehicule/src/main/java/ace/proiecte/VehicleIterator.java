package ace.proiecte;

import java.util.Iterator;
import java.util.List;

public class VehicleIterator implements Iterator<Vehicle> {
    private List<Vehicle> autovehicule;
    private int pozitie;

    public VehicleIterator(List<Vehicle> autovehicule) {
        this.autovehicule = autovehicule;
        this.pozitie = 0;
    }

    @Override
    public boolean hasNext() {
        return pozitie < autovehicule.size();
    }

    @Override
    public Vehicle next() {
        return autovehicule.get(pozitie++);
    }
}
