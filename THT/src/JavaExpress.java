import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExpress {
    public static void main(String[] args) {
        SistemReservasi reservasi = new SistemReservasi();
        Scanner input = new Scanner(System.in);
        boolean berjalan = true;

        try {
            //Perulangan menu utama selama program masih berjalan
            while (berjalan) {
                System.out.println("\n=== SISTEM RESERVASI JAVA EXPRESS ===");
                System.out.println("1. Lihat Jadwal Kereta");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1-3): ");

                int menu = 0;
                try {
                    //Membaca input dari pengguna
                    menu = input.nextInt();
                    input.nextLine(); // Membersihkan sisa buffer dari memori
                } catch (InputMismatchException e) {
                    //Menangani error jika pengguna salah memasukkan huruf dan lain sebagainya
                    System.out.println("Error: Input yang anda masukkan salah. Harap masukkan angka.");
                    input.nextLine(); // Membersihkan buffer error agar tidak infinite loop
                    continue; 
                }

                switch (menu) {
                    case 1:
                        //Menampilkan daftar jadwal kereta 
                        reservasi.tampilkanJadwal();
                        break;
                    case 2:
                    //Memanggil method untuk proses pemesanan tiket kereta
                        prosesMenuPesan(reservasi, input);
                        break;
                    case 3:
                        //Menghentikan program 
                        berjalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia. Silakan coba lagi.");
                }
            }
        } finally {
            //Ketika program sudah selesai akan menginput ini diakhir 
            System.out.println("Terima kasih telah menggunakan JAVA EXPRESS. Sampai jumpa!");
            input.close(); //Menutup scanner
        }
    }

    private static void prosesMenuPesan(SistemReservasi reservasi, Scanner input) {
        System.out.println("\nPEMESANAN TIKET");
        try {
            System.out.print("Masukkan Kode Kereta: ");
            String kode = input.nextLine();
            
            System.out.print("Masukkan NIK: ");
            String nik = input.nextLine();
            
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();
            
            System.out.print("Jumlah Tiket: ");
            int jumlah = input.nextInt();
            input.nextLine(); 

            System.out.print("Konfirmasi: Pesan " + jumlah + " tiket untuk " + nama + " (Y/N)? ");
            String konfirmasi = input.nextLine();
            //Kondisi jiak pengguna memilih "Y" maka pemesanan diproses, jika pengguna memilih "N" maka pemesanan dibatalkan secara otomatis
            if (konfirmasi.equalsIgnoreCase("Y")) {
                reservasi.pesanTiket(kode, nik, nama, jumlah);
                System.out.println("SUKSES! Tiket atas nama " + nama + " berhasil dipesan.");
            } else {
                System.out.println("Pemesanan dibatalkan oleh pengguna.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Jumlah tiket harus berupa angka.");
            input.nextLine(); 
        } catch (DataPenumpangTidakValidException e) {
            System.out.println("Error Validasi Data: " + e.getMessage()); //Menangani error jika data penumpang tidak valid
        } catch (RuteTidakDitemukanException | TiketHabisException e) {
            System.out.println("Error Reservasi: " + e.getMessage()); //Menangani error jika kode kereta tidak ditemukan atau tiket sudah habis
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan sistem yang tidak diketahui: " + e.getMessage()); //Menangani error lain yang tidak terduga
        }
    }
}