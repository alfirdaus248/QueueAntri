package QueueAntri;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RiwayatPasien {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void tambahRiwayat(Pasien pasien) {
        String sql = "INSERT INTO riwayat_pasien (nama, usia, keluhan, prioritas, waktu_kedatangan, waktu_selesai) "
                + "VALUES (?, ?, ?, ?, ?, NOW())";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pasien.nama);
            stmt.setInt(2, pasien.usia);
            stmt.setString(3, pasien.keluhan);
            stmt.setInt(4, pasien.prioritas);
            stmt.setString(5, pasien.waktuKedatangan.format(formatter)); // Konversi ke format SQL TIMESTAMP
            stmt.executeUpdate();
            System.out.println("Pasien berhasil disimpan ke riwayat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Pasien> ambilRiwayat() {
        List<Pasien> riwayat = new ArrayList<>();
        String sql = "SELECT * FROM riwayat_pasien ORDER BY waktu_selesai DESC";
        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nama = rs.getString("nama");
                int usia = rs.getInt("usia");
                String keluhan = rs.getString("keluhan");
                int prioritas = rs.getInt("prioritas");
                LocalDateTime waktuKedatangan = rs.getTimestamp("waktu_kedatangan").toLocalDateTime();
                LocalDateTime waktuSelesai = rs.getTimestamp("waktu_selesai").toLocalDateTime();

                Pasien pasien = new Pasien(nama, usia, keluhan, prioritas);
                pasien.waktuKedatangan = waktuKedatangan; // Set waktu kedatangan dari database
                pasien.waktuSelesai = waktuSelesai;
                riwayat.add(pasien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return riwayat;
    }
    
    public static List<Pasien> cariData(String cari){
        List<Pasien> pencari = new ArrayList<>();
        String sql = "SELECT * FROM riwayat_pasien WHERE nama LIKE '%"+cari+"%'";
        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nama = rs.getString("nama");
                int usia = rs.getInt("usia");
                String keluhan = rs.getString("keluhan");
                int prioritas = rs.getInt("prioritas");
                LocalDateTime waktuKedatangan = rs.getTimestamp("waktu_kedatangan").toLocalDateTime();
                LocalDateTime waktuSelesai = rs.getTimestamp("waktu_selesai").toLocalDateTime();

                Pasien pasien = new Pasien(nama, usia, keluhan, prioritas);
                pasien.waktuKedatangan = waktuKedatangan; // Set waktu kedatangan dari database
                pasien.waktuSelesai = waktuSelesai;
                pencari.add(pasien);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return pencari;
    }
}
