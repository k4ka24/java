import java.util.Scanner;

public class KalkulatorLingkaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double phi = 3.14159;

        System.out.print("Masukkan jari-jari lingkaran: ");
        double jariJari = input.nextDouble();

        // Menghitung luas
        double luas = phi * jariJari * jariJari;

        // Menghitung keliling
        double keliling = 2 * phi * jariJari;

        // Menampilkan hasil
        System.out.println("Luas lingkaran: " + luas);
        System.out.println("Keliling lingkaran: " + keliling);
    }
}