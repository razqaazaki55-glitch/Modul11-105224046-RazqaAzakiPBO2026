//Checked Exception untuk pencarian kode kereta yang mengalami kesalahan
public class RuteTidakDitemukanException extends Exception {
    public RuteTidakDitemukanException(String message) {
        super(message);
    }
}