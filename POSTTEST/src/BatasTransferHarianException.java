public class BatasTransferHarianException extends Exception {
    private int limitHarian;
    private double totalTransferDicoba;

    public BatasTransferHarianException(String pesan, int limitHarian, double totalTransferDicoba) {
        super(pesan);
        this.limitHarian = limitHarian;
        this.totalTransferDicoba = totalTransferDicoba;
    }

    public int getLimitHarian() {
        return limitHarian;
    }

    public double getTotalTransferDicoba() {
        return totalTransferDicoba;
    }
}