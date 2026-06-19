package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {
        // 1. Cek keberadaan dan ukuran laporan.txt (Sesuai Kunci Jawaban No. 1)
        File berkas = new File("laporan.txt");
        if (berkas.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkas.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        // 2. Membuat folder 'arsip' (Sesuai instruksi modul hal. 4)
        File folderArsip = new File("arsip");
        if (folderArsip.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat atau sudah ada.");
        }

        // 3. Membuat lalu menghapus file sementara.txt (Sesuai Kunci Jawaban No. 3)
        File berkasSementara = new File("sementara.txt");
        try {
            berkasSementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + berkasSementara.exists());
            
            berkasSementara.delete();
            System.out.println("Sesudah dihapus, ada? " + berkasSementara.exists());
        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}