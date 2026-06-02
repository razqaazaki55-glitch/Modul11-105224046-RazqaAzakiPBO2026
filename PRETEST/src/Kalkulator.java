import java.util.Scanner;
public class Kalkulator {
    public static void main(String[] args) throws Exception {
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan angka pertama(pembilang): ");
            double angka1 = input.nextDouble();
            System.out.print("Masukkan angka kedua(penyebut): ");
            double angka2 = input.nextDouble(); 
        } catch (Exception e) {
            System.out.println("Input dari anda error. Pastikan Anda memasukkan angka.");
        }
    }
}
