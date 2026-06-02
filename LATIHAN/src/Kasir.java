public class Kasir {
    //Soal 4
    public void bayar(int totalBelanja, int uangDiberikan) throws UangKurangException {
        if (uangDiberikan < totalBelanja) {
            throw new UangKurangException("Uang yang diberikan kurang. Uang yang dibutuhkan sebesar: " + totalBelanja + ", Sedangkan uang yang Diberikan sebesar: " + uangDiberikan);
        }
        int kembalian = uangDiberikan - totalBelanja;
        System.out.println("Pembayaran sukses. Kembalian: " + kembalian);
    }

    //Soal 5
    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (!statusPrinter) {
            throw new Exception("Kertas struk habis!");
        }
    }
}