package QueueAntri;

import java.util.*;

public class MainApp {

    private static Queue<Pasien> antrean = new LinkedList<>();
    private static PriorityQueue<Pasien> antreanPrioritas = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Antrian Rumah Sakit ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Proses Pasien");
            System.out.println("4. Tampilkan Riwayat Pasien");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Usia: ");
                    int usia = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    System.out.print("Keluhan: ");
                    String keluhan = scanner.nextLine();
                    System.out.print("Prioritas (1 = Darurat, 2 = Reguler): ");
                    int prioritas = scanner.nextInt();

                    Pasien pasienBaru = new Pasien(nama, usia, keluhan, prioritas);

                    if (prioritas == 1) {
                        antreanPrioritas.add(pasienBaru);
                    } else {
                        antrean.add(pasienBaru);
                    }
                    System.out.println("Pasien berhasil ditambahkan ke antrean.");
                    break;

                case 2:
                    System.out.println("Antrian Prioritas:");
                    antreanPrioritas.forEach(System.out::println);

                    System.out.println("\nAntrian Reguler:");
                    antrean.forEach(System.out::println);
                    break;

                case 3:
                    Pasien pasienDiproses = null;
                    if (!antreanPrioritas.isEmpty()) {
                        pasienDiproses = antreanPrioritas.poll();
                    } else if (!antrean.isEmpty()) {
                        pasienDiproses = antrean.poll();
                    }

                    if (pasienDiproses != null) {
                        System.out.println("Pasien yang diproses: " + pasienDiproses);
                        RiwayatPasien.tambahRiwayat(pasienDiproses);
                    } else {
                        System.out.println("Tidak ada pasien dalam antrean.");
                    }
                    break;

                case 4:
                    List<Pasien> riwayat = RiwayatPasien.ambilRiwayat();
                    System.out.println("Riwayat Pasien yang Telah Diproses:");
                    riwayat.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}
