import java.util.ArrayList;
import java.util.Scanner;

class Produk {
    String nama;
    double harga;

    Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
}
    public class mini {
    static ArrayList<Produk> daftarProduk = new ArrayList<>();
    static ArrayList<Produk> keranjang = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tambah produk contoh ke daftar
        daftarProduk.add(new Produk("Beras", 50000));
        daftarProduk.add(new Produk("Minyak Goreng", 30000));
        daftarProduk.add(new Produk("Gula", 12000));
        daftarProduk.add(new Produk("Kopi", 15000));

        int pilihan;
        do {
            System.out.println("\n===== Mini Market =====");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Tambah ke Keranjang");
            System.out.println("3. Lihat Keranjang");
            System.out.println("4. Bayar");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (pisahkan dengan koma untuk memilih lebih dari satu): ");
            String input = scanner.nextLine();
            String[] pilihanArray = input.split(",");
            
            for (String p : pilihanArray) {
                try {
                    pilihan = Integer.parseInt(p.trim());
                    switch (pilihan) {
                        case 1:
                            tampilkanProduk();
                            break;
                        case 2:
                            tambahKeKeranjang();
                            break;
                        case 3:
                            lihatKeranjang();
                            break;
                        case 4:
                            bayar();
                            break;
                        case 5:
                            System.out.println("Terima kasih telah berbelanja!");
                            return;
                        default:
                            System.out.println("Pilihan tidak valid!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid, harap masukkan angka.");
                }
            }
        } while (true);
    }

    static void tampilkanProduk() {
        System.out.println("\nDaftar Produk:");
        for (int i = 0; i < daftarProduk.size(); i++) {
            System.out.println((i + 1) + ". " + daftarProduk.get(i).nama + " - Rp " + daftarProduk.get(i).harga);
        }
    }

    static void tambahKeKeranjang() {
        tampilkanProduk();
        System.out.print("Masukkan nomor produk yang ingin ditambahkan (pisahkan dengan koma untuk lebih dari satu): ");
        String input = scanner.nextLine();
        String[] indeksArray = input.split(",");
        
        for (String indeksStr : indeksArray) {
            try {
                int indeks = Integer.parseInt(indeksStr.trim()) - 1;
                if (indeks >= 0 && indeks < daftarProduk.size()) {
                    keranjang.add(daftarProduk.get(indeks));
                    System.out.println(daftarProduk.get(indeks).nama + " telah ditambahkan ke keranjang.");
                } else {
                    System.out.println("Nomor produk tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, harap masukkan angka.");
            }
        }
    }

    static void lihatKeranjang() {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang belanja Anda kosong.");
        } else {
            System.out.println("\nIsi Keranjang:");
            double total = 0;
            for (Produk p : keranjang) {
                System.out.println(p.nama + " - Rp " + p.harga);
                total += p.harga;
            }
            System.out.println("Total: Rp " + total);
        }
    }

    static void bayar() {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang masih kosong, tambahkan produk terlebih dahulu.");
            return;
        }

        double total = 0;
        for (Produk p : keranjang) {
            total += p.harga;
        }
        
        System.out.println("Total yang harus dibayar: Rp " + total);
        System.out.print("Masukkan jumlah uang: Rp ");
        double uang = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer
        
        if (uang >= total) {
            System.out.println("Pembayaran berhasil! Kembalian Anda: Rp " + (uang - total));
            keranjang.clear();
        } else {
            System.out.println("Uang tidak mencukupi. Pembayaran gagal.");
        }
    }
}