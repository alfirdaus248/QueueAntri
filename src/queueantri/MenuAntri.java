/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QueueAntri;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author LENOVO
 */
public class MenuAntri extends javax.swing.JFrame {
    public static Queue<Pasien> antrean = new LinkedList<>();
    private static PriorityQueue<Pasien> antreanPrioritas = new PriorityQueue<>();
    /**
     * Creates new form Antri
     */
    public MenuAntri() {
        initComponents();
        tampil_data();
        
        // Kustomisasi header tabel dengan border tebal
        JTableHeader header = tabel_antri.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 16)); // Font tebal
        header.setBackground(Color.WHITE);                   // Latar putih
        header.setForeground(Color.BLACK);                   // Teks hitam
        header.setOpaque(true);

        // Mengatur renderer untuk header dengan border
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("SansSerif", Font.BOLD, 16));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Border hitam
                label.setBackground(Color.WHITE);
                label.setOpaque(true);
                return label;
            }
        });

        // Kustomisasi isi tabel
        tabel_antri.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabel_antri.setRowHeight(30); // Tinggi baris
        tabel_antri.setGridColor(Color.BLACK); // Garis tabel hitam

        // Menyiapkan model kosong untuk tabel
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"Nama", "Usia", "Keluhan", "Prioritas"});
        tabel_antri.setModel(model);
    }
    
    public void tambahAntri(String nama, int usia, String keluhan, int prioritas){
        Pasien pasienBaru = new Pasien(nama, usia, keluhan, prioritas);
        if (prioritas == 1) {
            antreanPrioritas.add(pasienBaru);
        } else {
            antrean.add(pasienBaru);
        }
        System.out.println("Pasien berhasil ditambahkan ke antrean.");
    }
    
    public void tampil_data() {
        // Kolom tabel
        Object[] kolom = {"Nama", "Usia", "Keluhan", "Prioritas"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        
        // Tambahkan data dari antrean prioritas
        for (Pasien pasien : antreanPrioritas) {
            String prioritas = pasien.getPrioritas() == 1 ? "Darurat" : "Reguler";
            Object[] rowData = {pasien.getNama(), pasien.getUsia(), pasien.getKeluhan(), prioritas};
            model.addRow(rowData);
        }

        // Tambahkan data dari antrean reguler
        for (Pasien pasien : antrean) {
            String prioritas = pasien.getPrioritas() == 1 ? "Darurat" : "Reguler";
            Object[] rowData = {pasien.getNama(), pasien.getUsia(), pasien.getKeluhan(), prioritas};
            model.addRow(rowData);
        }

        // Set model ke tabel
        tabel_antri.setModel(model);
    }
    
    public boolean prosesAntri(){
        Pasien pasienDiproses = null;
        if (!antreanPrioritas.isEmpty()) {
            // poll sama dengan remove
            // indeks pertama dihapus
            pasienDiproses = antreanPrioritas.poll();
        } else if (!antrean.isEmpty()) {
            pasienDiproses = antrean.poll();
        }

        if (pasienDiproses != null) {
            System.out.println("Pasien yang diproses: " + pasienDiproses);
            RiwayatPasien.tambahRiwayat(pasienDiproses);
        } else {
            System.out.println("Tidak ada pasien dalam antrean.");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_antri = new javax.swing.JTable();
        Gambar = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_proses = new javax.swing.JButton();
        btn_riwayat = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Antre Pasien Rumah Sakit");
        setLocation(new java.awt.Point(100, 5));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        tabel_antri.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        tabel_antri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_antri.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabel_antri);
        if (tabel_antri.getColumnModel().getColumnCount() > 0) {
            tabel_antri.getColumnModel().getColumn(0).setHeaderValue("");
            tabel_antri.getColumnModel().getColumn(1).setResizable(false);
            tabel_antri.getColumnModel().getColumn(2).setResizable(false);
            tabel_antri.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 820, 350));

        Gambar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/queueantri/UI/ManajemenPasien.png"))); // NOI18N
        getContentPane().add(Gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1040, 810));

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, 170, 50));

        btn_proses.setText("Proses");
        btn_proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_proses, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 620, 160, 50));

        btn_riwayat.setText("Riwayat");
        btn_riwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_riwayatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_riwayat, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, 170, 40));

        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 620, 170, 40));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        TambahAntrian antri = new TambahAntrian();
        dispose();
        antri.setVisible(true);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosesActionPerformed
        if(prosesAntri()){
            JOptionPane.showMessageDialog(null, "Antrean Pasien Berhasil diproses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampil_data();
        } else{
            JOptionPane.showMessageDialog(null, "Tidak ada Pasien dalam Antrean.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_prosesActionPerformed

    private void btn_riwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_riwayatActionPerformed
        Riwayat riw = new Riwayat();
        dispose();
        riw.setVisible(true);
    }//GEN-LAST:event_btn_riwayatActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar ?","Warning",2)== JOptionPane.YES_OPTION){
        System.exit(0);
        }
    }//GEN-LAST:event_btn_keluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAntri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAntri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAntri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAntri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAntri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gambar;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_proses;
    private javax.swing.JButton btn_riwayat;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_antri;
    // End of variables declaration//GEN-END:variables
}
