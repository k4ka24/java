package Tugas_java.com.tugas;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        System.out.println("Daftar Buku:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " oleh " + book.getAuthor() + (book.isAvailable() ? " (Tersedia)" : " (Dipinjam)"));
        }
    }

    public Book borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrow();
                return book;
            }
        }
        return null;
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.returnBook();
                System.out.println("Buku '" + title + "' telah dikembalikan.");
                return;
            }
        }
        System.out.println("Buku '" + title + "' tidak ditemukan atau belum dipinjam.");
    }
}
public class Peminjaman_buku {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan beberapa buku ke perpustakaan
        library.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("1984", "George Orwell"));

        while (true) {
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (choice) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowedBook = library.borrowBook(borrowTitle);
                    if (borrowedBook != null) {
                        System.out.println("Anda telah meminjam buku: " + borrowedBook.getTitle());
                    } else {
                        System.out.println("Buku tidak tersedia untuk dipinjam.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}