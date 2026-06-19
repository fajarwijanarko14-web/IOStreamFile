package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LatihanMandiriBacaTulis {
    public static void main(String[] args) {
        String namaFile = "hari.txt";

        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaFile))) {
            penulis.println("Senin");
            penulis.println("Selasa");
            penulis.println("Rabu");
            penulis.println("Kamis");
            penulis.println("Jumat");
            System.out.println("5 nama hari telah ditulis.");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        System.out.println("--- Isi hari.txt (awal) ---");
        tampilkanIsiBerkas(namaFile);

        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaFile, true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("\n2 nama hari berhasil ditambahkan (append).");
        } catch (IOException e) {
            System.out.println("Gagal append: " + e.getMessage());
        }

        System.out.println("\n--- Isi hari.txt (akhir) & Hitung Baris ---");
        hitungDanTampilkanBaris(namaFile);
    }

    public static void tampilkanIsiBerkas(String file) {
        try (BufferedReader pembaca = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }

    public static void hitungDanTampilkanBaris(String file) {
        int jumlah = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
                jumlah++;
            }
            System.out.println("Jumlah baris: " + jumlah);
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }
}