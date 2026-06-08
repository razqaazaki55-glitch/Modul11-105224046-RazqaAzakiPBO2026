import java.util.HashMap;
import java.util.Map;

public class SistemReservasi {
    private Map<String, KeretaApi> daftarKereta;
    
    public SistemReservasi() {
        daftarKereta = new HashMap<String, KeretaApi>();
        //Daftar kereta menggunakan kunci 
        daftarKereta.put("K01", new KeretaApi("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.put("K02", new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public void tampilkanJadwal() {
        System.out.println("=== Jadwal Kereta ===");
        for(KeretaApi kereta: daftarKereta.values()){
            System.out.println("Kode Kereta: " + kereta.getKodeKereta());
            System.out.println("Kode: " + kereta.getKodeKereta() + "|" + "Nama Kereta: " + kereta.getNamaKereta() + "|" + "Rute: " + kereta.getRute() + "|" + "Kapasitas: " + kereta.getSisaKursi());       
        }
    }

    //Metode transaksi reservasi dengan validasi ketat
    public void pesanTiket(String kode, String nik, String nama, int jumlah) 
           throws RuteTidakDitemukanException, TiketHabisException {
               
        //Validasi NIK
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException("NIK tidak valid! Harus tepat 16 digit angka.");
        }

        //Pencarian Kereta menggunakan fitur instan HashMap
        KeretaApi keretaDipesan = daftarKereta.get(kode);

        //Jika kereta tidak ditemukan di HashMap, maka gagal akam dilempar ke Exception
        if (keretaDipesan == null) {
            throw new RuteTidakDitemukanException("Gagal: Kereta dengan kode " + kode + " tidak ditemukan.");
        }

        //Mengecek sisa Kursi
        if (jumlah > keretaDipesan.getSisaKursi()) {
            throw new TiketHabisException(keretaDipesan.getNamaKereta(), keretaDipesan.getSisaKursi());
        }

        // Jika semua mengecek semua berhasil, maka jumlah kursi dikurangi 
        keretaDipesan.kurangiKursi(jumlah);

        System.out.println("=== Konfirmasi Pemesanan ===");
        System.out.println("Nama Penumpang: " + nama);
        System.out.println("NIK: " + nik);
        System.out.println("Kereta: " + keretaDipesan.getNamaKereta() + " (" + keretaDipesan.getKodeKereta() + ")");
        System.out.println("Rute: " + keretaDipesan.getRute());
        System.out.println("Jumlah Tiket: " + jumlah);
        System.out.println("Sisa Kursi: " + keretaDipesan.getSisaKursi());
    }
}