//Unchecked Exception untuk mengecek NIK penumpang  
public class DataPenumpangTidakValidException extends RuntimeException {
    public DataPenumpangTidakValidException(String message) {
        super(message);
    }
}