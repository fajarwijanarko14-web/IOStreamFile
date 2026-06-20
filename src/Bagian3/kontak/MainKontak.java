package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Membuat objek BukuKontak
        BukuKontak buku = new BukuKontak("kontak.txt");

        // Menambahkan kontak baru (dengan Nama, Nomor, Email)
        buku.tambahKontak(new Kontak("Andi", "0812345678", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0898765432", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0811223344", "citra@email.com"));

        // Menyimpan data ke dalam file
        buku.simpanKeBerkas();

        System.out.println();

        // Menguji fitur Cari Kontak
        System.out.println("Mencari kontak 'Andi':");
        buku.cariKontak("Andi");

        System.out.println();

        // Menguji fitur Hapus Kontak
        System.out.println("Menghapus kontak 'Budi':");
        buku.hapusKontak("Budi");

        System.out.println();

        // Menampilkan sisa kontak setelah dihapus
        buku.tampilkanSemua();
        
        System.out.println();

        // Memuat ulang data dari file untuk memastikan data permanen
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        System.out.println("Jumlah kontak di file: " + bukuLain.jumlahKontak());
    }
}