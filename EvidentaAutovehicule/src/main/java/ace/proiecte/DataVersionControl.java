package ace.proiecte;



import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataVersionControl {
    private static final String FOLDER_SAVE = "saves";

    static {
        // Creează folderul dacă nu există
        File folder = new File(FOLDER_SAVE);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void saveData(List<Vehicle> autovehicule) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = FOLDER_SAVE + "/backup_" + timestamp + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(autovehicule);
            System.out.println("Datele au fost salvate în: " + fileName);
        }
    }

    public static List<String> getBackup() {
        File folder = new File(FOLDER_SAVE);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".ser"));
        List<String> salvate = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                salvate.add(file.getName());
            }
        }
        return salvate;
    }

    public static List<Vehicle> loadData(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FOLDER_SAVE + "/" + fileName))) {
            return (List<Vehicle>) ois.readObject();
        }
    }
}
