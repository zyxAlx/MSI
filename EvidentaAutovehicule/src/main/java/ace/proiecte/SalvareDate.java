package ace.proiecte;

import java.io.*;
import java.util.List;
//baza de date
public class SalvareDate {
    public static void salveazaDate(List<Autovehicul> autovehicule, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(autovehicule);
        }
    }

    public static List<Autovehicul> incarcaDate(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Autovehicul>) ois.readObject();
        }
    }
}
