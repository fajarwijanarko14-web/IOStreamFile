package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {
        // laporan.txt
        File fileLaporan = new File("laporan.txt");
        if (fileLaporan.exists()) {
            System.out.println("Berkas 'laporan.txt' ditemukan. Ukuran: " + fileLaporan.length() + " byte.");
        } else {
            System.out.println("Berkas 'laporan.txt' tidak ditemukan.");
        }

        // folder 'arsip'
        File folderArsip = new File("arsip");
        if (folderArsip.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Gagal membuat folder 'arsip' (mungkin sudah ada).");
        }

        // Buat dan hapus sementara.txt
        File fileSementara = new File("sementara.txt");
        try {
            if (fileSementara.createNewFile()) {
                System.out.println("Sebelum dihapus: File ada? " + fileSementara.exists());
                fileSementara.delete();
                System.out.println("Setelah dihapus: File ada? " + fileSementara.exists());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}