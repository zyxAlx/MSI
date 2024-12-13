package ace.proiecte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class GraphicalInterface {
    private VehicleAdministrator admin;
    private JFrame frame;

    public GraphicalInterface(VehicleAdministrator admin) {
        this.admin = admin;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Evidenta Autovehiculelor");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // title
        JLabel headerLabel = new JLabel("Evidența Autovehiculelor", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.BLUE);
        frame.add(headerLabel, BorderLayout.NORTH);

        // Panel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));  // layout cu 4 rânduri și 1 coloană
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // register butTon
        JButton adaugaButton = new JButton("Înmatriculare Autovehicul");
        styleButton(adaugaButton);
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inmatriculeazaAutovehicul();
            }
        });

        //  save button
        JButton salveazaButton = new JButton("Salvează Datele");
        styleButton(salveazaButton);
        salveazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salveazaDate();
            }
        });

        // load button
        JButton incarcaButton = new JButton("Încarcă Date");
        styleButton(incarcaButton);
        incarcaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incarcaDate();
            }
        });

        // serch by owner
        JButton cautaButton = new JButton("Caută Proprietar");
        styleButton(cautaButton);
        cautaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautaDupaProprietar();
            }
        });

        // add functionalies on buttons
        buttonPanel.add(adaugaButton);
        buttonPanel.add(salveazaButton);
        buttonPanel.add(incarcaButton);
        buttonPanel.add(cautaButton);

        frame.add(buttonPanel, BorderLayout.CENTER);  // centrarea ferestrei

        frame.setVisible(true);
    }

    // buttons styles
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);  // Text alb
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(250, 40));
    }

    private void inmatriculeazaAutovehicul() {
        try {
            String tip = JOptionPane.showInputDialog("Introduceți tipul autovehiculului:");
            String marca = JOptionPane.showInputDialog("Introduceți marca:");
            int cilindree = Integer.parseInt(JOptionPane.showInputDialog("Introduceți cilindreea:"));
            String culoare = JOptionPane.showInputDialog("Introduceți culoarea:");

            String numeProprietar = JOptionPane.showInputDialog("Introduceți numele proprietarului:");
            String prenumeProprietar = JOptionPane.showInputDialog("Introduceți prenumele proprietarului:");
            String cnp = JOptionPane.showInputDialog("Introduceți CNP-ul proprietarului:");

            Proprietar proprietar = new Proprietar(numeProprietar, prenumeProprietar, cnp);
            String dataInmatricularii = JOptionPane.showInputDialog("Introduceți data înmatriculării (yyyy-mm-dd):");

            RegisterVehicle registerVehicle = new RegisterVehicle(dataInmatricularii);
            Vehicle auto = new Vehicle(tip, marca, cilindree, culoare, proprietar, registerVehicle);
            admin.inmatriculareAutovehicul(auto, registerVehicle);

            JOptionPane.showMessageDialog(frame, "Autovehicul înmatriculat cu succes!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Eroare la introducerea datelor: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salveazaDate() {
        try {
            DataVersionControl.saveData(admin.getAutovehicule());
            JOptionPane.showMessageDialog(frame, "Datele au fost salvate cu succes!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Eroare la salvarea datelor: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void incarcaDate() {
        List<String> backupuri = DataVersionControl.getBackup();

        if (backupuri.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nu există fișiere de backup.", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedFileName = (String) JOptionPane.showInputDialog(
                frame,
                "Alege fișierul de backup:",
                "Selectează un backup",
                JOptionPane.PLAIN_MESSAGE,
                null,
                backupuri.toArray(),
                backupuri.get(0)
        );

        if (selectedFileName != null) {
            try {
                List<Vehicle> autovehicule = DataVersionControl.loadData(selectedFileName);
                for (Vehicle auto : autovehicule) {
                    admin.inmatriculareAutovehicul(auto, auto.getInmatriculare());
                }
                JOptionPane.showMessageDialog(frame, "Datele au fost încărcate cu succes!");
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "Eroare la încărcarea datelor: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cautaDupaProprietar() {
        try {
            String numeProprietar = JOptionPane.showInputDialog("Introduceți numele proprietarului:");

            List<Vehicle> rezultate = CautareAutovehicul.cautaDupaProprietar(admin.getAutovehicule(), numeProprietar);

            if (rezultate.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Nu au fost găsite autovehicule pentru proprietarul specificat.");
            } else {
                StringBuilder sb = new StringBuilder("Autovehiculele găsite:\n");
                for (Vehicle auto : rezultate) {
                    sb.append(auto).append("\n");
                }
                JOptionPane.showMessageDialog(frame, sb.toString());
            }
        } catch (NullVehicleListException ex) {
            JOptionPane.showMessageDialog(frame, "Eroare: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Eroare neașteptată: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }
}
