public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalTransferHariIni() {
        return totalTransferHariIni;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;

            throw new SaldoTidakMencukupiException("Penarikan gagal karena saldo tidak mencukupi.", kekurangan);
        }

        saldo -= nominal;

        System.out.println("Tarik tunai berhasil sebesar Rp " + nominal);
        System.out.println("Sisa saldo: Rp " + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal) throws SaldoTidakMencukupiException, BatasTransferHarianException {

        int limitTransferHarian = 10000000;

        double totalSetelahTransfer = totalTransferHariIni + nominal;

        if (totalSetelahTransfer > limitTransferHarian) {
            throw new BatasTransferHarianException("Transfer gagal karena melebihi batas transfer harian.", limitTransferHarian, totalSetelahTransfer
            );
        }

        if (nominal > saldo) {
            double kekurangan = nominal - saldo;

            throw new SaldoTidakMencukupiException("Transfer gagal karena saldo tidak mencukupi.", kekurangan
            );
        }

        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHariIni += nominal;

        System.out.println("Transfer berhasil sebesar Rp " + nominal);
        System.out.println("Ke rekening: " + tujuan.getNomorRekening());
        System.out.println("Sisa saldo pengirim: Rp " + saldo);
    }
}