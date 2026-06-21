package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void tampilkanSemua() {
        for (Barang b : daftarBarang) {
            System.out.println(b.info());
        }
    }

    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total = total + (b.getHarga() * b.getStok());
        }
        return total;
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftarBarang.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat dari berkas: " + e.getMessage());
        }
    }
}