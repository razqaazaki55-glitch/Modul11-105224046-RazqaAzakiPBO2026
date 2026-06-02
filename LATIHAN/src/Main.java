import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Soal 1
        int[] hargaMenu = new int[3];
        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                int harga = scanner.nextInt();
                hargaMenu[i] = harga; 
                System.out.println("Harga tersimpan untuk menu ke-" + (i + 1) + ": " + harga);
            } catch (InputMismatchException ime) {
                System.out.println("Error: Input harga harus berupa angka!");
                scanner.nextLine();
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("Error: Kapasitas memori harga sudah penuh!");
            }
        }

        System.out.println();

        //Bagian soal 2 dan 3
        Pelanggan pelanggan = new Pelanggan();

        //Soal 2
        try {
            pelanggan.daftarMember(15); 
        } catch (IllegalArgumentException r) {
            System.out.println(r.getMessage());
        }

        //Soal 3
        try {
            pelanggan.pesanKopi(10); 
        } catch (KopiHabisException i) {
            System.out.println("Error: " + i.getMessage());
        }

        System.out.println();

        //Bagian soal 4 dan 5
        Kasir kasir = new Kasir();

        try {
            //Soal 4
            kasir.bayar(50000, 30000);
        } catch (UangKurangException z) {
            System.out.println("Pembayaran Error: " + z.getMessage());
        }

        try {
            //Soal 5
            kasir.cetakStruk(false);
        } catch (Exception e) {
            System.out.println("Printer error: " + e.getMessage());
        } finally {
            System.out.println("Terima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
        }

        scanner.close();
    }
}