package tugas;

// Nama: [Tulis Nama Kamu di Sini]
// NPM: [Tulis NPM Kamu di Sini]

public class MainTugas {
    public static void main(String[] args) {
        // 1. Array nama kategori (minimal 3)
        String[] kategori = {"Elektronik", "Alat Tulis", "Pakaian"};
        
        System.out.println("=== Kategori Barang ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.println();

        // 2. Operasi Gudang
        Gudang gudang = new Gudang("barang.txt");
        
        gudang.tambahBarang(new Barang("Laptop", 5000000, 5));
        gudang.tambahBarang(new Barang("Buku", 5000, 100));
        gudang.tambahBarang(new Barang("Pensil", 2000, 200));
        gudang.tambahBarang(new Barang("Kemeja", 150000, 20));
        gudang.tambahBarang(new Barang("Mouse", 100000, 50));
        
        gudang.simpanKeBerkas();
        
        // 3. Objek Gudang baru untuk memuat ulang data dari berkas
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        
        System.out.println("=== Data Barang dari Berkas ===");
        gudangBaru.tampilkanSemua();
        
        System.out.println("\nTotal Nilai Persediaan: " + gudangBaru.totalNilai());
    }
}