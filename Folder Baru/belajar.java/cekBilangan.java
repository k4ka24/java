import java.util.Scanner;
  public class cekBilangan {
  
    public static void main(String[] args) {
        // Membuat scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);

        // Meminta input angka dari pengguna
        System.out.print("Masukkan sebuah angka: ");
        double angka = scanner.nextDouble();

        // Mengecek apakah angka positif, negatif, atau nol menggunakan if
        if (angka > 0) {
            System.out.println(angka + " adalah bilangan positif.");
        } else if (angka < 0) {
            System.out.println(angka + " adalah bilangan negatif.");
        } else {
            System.out.println(angka + " adalah nol.");
        }

        // Menutup scanner
        scanner.close();
    }
}

