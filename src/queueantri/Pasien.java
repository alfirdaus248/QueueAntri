package QueueAntri;

import java.time.LocalDateTime;

public class Pasien implements Comparable<Pasien> {
    protected String nama;
    protected int usia;
    protected String keluhan;
    protected int prioritas;
    protected LocalDateTime waktuKedatangan; // Waktu masuk antrean
    protected LocalDateTime waktuSelesai;// Waktu keluar antrean

    public Pasien(String nama, int usia, String keluhan, int prioritas) {
        this.nama = nama;
        this.usia = usia;
        this.keluhan = keluhan;
        this.prioritas = prioritas;
        this.waktuKedatangan = LocalDateTime.now(); // Catat waktu saat pasien dibuat
    }
    
//    public void setNama(String nama){
//        this.nama = nama;
//    }
    
    public String getNama(){
        return nama;
    }
    
//    public void setUsia(int usia){
//        this.usia = usia;
//    }
    
    public int getUsia(){
        return usia;
    }
    
//    public void setKeluhan(String keluhan){
//        this.keluhan = keluhan;
//    }
    
    public String getKeluhan(){
        return keluhan;
    }
    
//    public void setPrioritas(int prioritas){
//        this.prioritas = prioritas;
//    }
    
    public int getPrioritas(){
        return prioritas;
    }
    
//    public void setWaktuDatang(LocalDateTime waktuKedatangan){
//        this.waktuKedatangan = waktuKedatangan;
//    }
    
    public LocalDateTime getWaktuDatang(){
        return waktuKedatangan;
    }
    
    public LocalDateTime getWaktuSelesai(){
        return waktuSelesai;
    }

    @Override
    public int compareTo(Pasien other) {
        return Integer.compare(other.prioritas, this.prioritas);
    }

    @Override
    public String toString() {
        return "Pasien{"
                + "Nama='" + nama + '\''
                + ", Usia=" + usia
                + ", Keluhan='" + keluhan + '\''
                + ", Prioritas=" + (prioritas == 1 ? "Darurat" : "Reguler")
                + ", Waktu Kedatangan=" + waktuKedatangan
                + '}';
    }
}
