package ace.proiecte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfataGrafica {
    private GestorAutovehicule gestor;
    private JFrame frame;

    public InterfataGrafica(GestorAutovehicule gestor) {
        this.gestor = gestor;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Evidenta Autovehiculelor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adăugare butoane și câmpuri pentru interacțiune
        JButton adaugaButton = new JButton("Inmatriculare autovehicul");
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cod pentru a adăuga un autovehicul
                String tip = JOptionPane.showInputDialog("Introduceți tipul autovehiculului:");
                String marca = JOptionPane.showInputDialog("Introduceți marca:");
                int cilindree = Integer.parseInt(JOptionPane.showInputDialog("Introduceți cilindreea:"));
                String culoare = JOptionPane.showInputDialog("Introduceți culoarea:");

                // Cerem informațiile despre proprietar
                String numeProprietar = JOptionPane.showInputDialog("Introduceți numele proprietarului:");
                String prenumeProprietar = JOptionPane.showInputDialog("Introduceți adresa proprietarului:");
                String cnp = JOptionPane.showInputDialog("Introduceți adresa proprietarului:");


                Proprietar proprietar = new Proprietar(numeProprietar, prenumeProprietar,cnp);


                // informațiile de înmatriculare
               // String numarInmatriculare = JOptionPane.showInputDialog("Introduceți numărul de înmatriculare:");
                String dataInmatricularii = JOptionPane.showInputDialog("Introduceți data înmatriculării (yyyy-mm-dd):");

                Inmatriculare inmatriculare = new Inmatriculare( dataInmatricularii);
                Autovehicul auto = new Autovehicul(tip, marca, cilindree, culoare, proprietar,inmatriculare);
                gestor.inmatriculareAutovehicul(auto, inmatriculare);
            }
        });

        frame.getContentPane().add(adaugaButton);
        frame.setVisible(true);
    }
}
