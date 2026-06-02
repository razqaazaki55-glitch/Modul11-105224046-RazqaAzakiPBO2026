public class Pelanggan {
    private int stokKopi = 5;

    //Soal 2
    public void daftarMember(int umur) {
        if (umur < 17) {
            throw new IllegalArgumentException("Maaf, umur Anda belum mencukupi untuk menjadi Member VIP");
        }
        System.out.println("Pendaftaran Member VIP berhasil. Selamat!");
    }

    //Soal 3
    public void pesanKopi(int jumlahPesanan) {
        if (jumlahPesanan > stokKopi) {
            throw new KopiHabisException("Stok kopi tidak mencukupi. Stok saat ini: " + stokKopi);
        }
        stokKopi -= jumlahPesanan;
        System.out.println("Pesanan " + jumlahPesanan + " kopi berhasil. Sisa stok: " + stokKopi);
    }

    public int getStokKopi() {
        return stokKopi;
    }
}