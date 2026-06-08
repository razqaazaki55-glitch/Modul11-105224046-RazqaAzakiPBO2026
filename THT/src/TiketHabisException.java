//Checked Exception jika kapasitas kursi tidak cukup  
public class TiketHabisException extends Exception {
    private String namaKereta;
    private int sisaKursi;
 
    public TiketHabisException(String namaKereta, int sisaKursi) {
        super("Tiket habis untuk kereta " + namaKereta + ". Saat ini kursi hanya tersisa: " + sisaKursi + ".");
        this.namaKereta = namaKereta;
        this.sisaKursi = sisaKursi;
    }
 
    public String getNamaKereta() { return namaKereta; }
    public int getSisaKursi() { return sisaKursi; }
}