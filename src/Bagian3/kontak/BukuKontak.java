package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // Menggunakan ArrayList dengan tipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah kontak baru ke dalam daftar
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    // Menampilkan seluruh daftar kontak
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // Mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Menghapus kontak berdasarkan nama dan memperbarui berkas
    public void hapusKontak(String nama) {
        boolean berhasilDihapus = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                berhasilDihapus = true;
                break;
            }
        }

        if (berhasilDihapus) {
            simpanKeBerkas();
            System.out.println("Kontak " + nama + " telah berhasil dihapus.");
        } else {
            System.out.println("Kontak " + nama + " tidak ditemukan, tidak ada yang dihapus.");
        }
    }

    // Menyimpan semua data dari ArrayList ke dalam file .txt
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Data berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan: " + e.getMessage());
        }
    }

    // Membaca data dari file dan memecahnya menjadi 3 bagian (nama;nomor;email)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    Kontak kontakBaru = new Kontak(bagian[0], bagian[1], bagian[2]);
                    daftar.add(kontakBaru);
                }
            }
            System.out.println("Data berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memuat data: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}