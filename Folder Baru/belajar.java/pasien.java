
//data pasien rs ibnu santai
import java.util.Scanner;

public class pasien {
    public static void main(String[] args) {
        // mengolah input data sederhana 
        // menggunakan class scanner
        int Id_pasien, Usia_pasien; 
        String Nama_pasien, Alamat_pasien, Keluhan_pasien;
        Scanner Input = new Scanner(System.in);
        System.out.println("DATA PASIEN");
        System.out.println("----------");
        System.out.print("Id pasien : ");
        Id_pasien= Input.nextInt();
        System.out.print("Nama pasien : ");
        Nama_pasien = Input.next();
        System.out.print("Alamat pasien : ");
        Alamat_pasien = Input.next();
        System.out.print("Usia pasien : ");
        Usia_pasien = Input.nextInt();
        System.out.print("Keluhan pasien : ");
        Keluhan_pasien = Input.next();
        // menampilkan daata pasien 
        System.out.println("DATA PASIEN");
        System.out.println("----------");
        System.out.println("Id pasien : " + Id_pasien);
        System.out.println("Nama pasien : " + Nama_pasien);
        System.out.println("Alamat pasien : " + Alamat_pasien);
        System.out.println("Usia pasien : " + Usia_pasien);
        System.out.println("keluhan pasien : " + Keluhan_pasien);
    }    
}