/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueantri.UI;

/**
 *
 * @author User
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomTableDemo extends JFrame {

    public CustomTableDemo() {
        setTitle("Tabel Keluhan Pasien");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Data untuk tabel
        Object[][] data = {
                {"Budi", 25, "Demam tinggi", "Tinggi"},
                {"Siti", 30, "Batuk dan pilek", "Sedang"},
                {"Andi", 40, "Sakit kepala", "Rendah"},
                {"Dewi", 35, "Nyeri perut", "Tinggi"}
        };

        // Kolom tabel
        String[] columnNames = {"Nama", "Usia", "Keluhan", "Prioritas"};

        // Membuat tabel dengan model
        JTable table = new JTable(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Membuat sel tidak dapat diedit
            }
        };

        // Custom render untuk header tabel
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.setBackground(new Color(60, 63, 65));
        header.setForeground(Color.WHITE);

        // Mengatur ukuran font isi tabel
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(25);

        // Custom render untuk isi tabel
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Menambahkan tabel ke dalam scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setLocationRelativeTo(null); // Untuk menampilkan di tengah layar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomTableDemo demo = new CustomTableDemo();
            demo.setVisible(true);
        });
    }
}

