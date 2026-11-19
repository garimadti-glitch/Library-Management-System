import java.util.ArrayList;
import java.util.List;

class Book {
    int id;
    String title;
    boolean isAvailable;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return id + ". " + title + " (" + (isAvailable ? "Available" : "Borrowed") + ")";
    }
}

public class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.title);
    }

    void showBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    void borrowBook(int id) {
        for (Book b : books) {
            if (b.id == id && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("\nBorrowed: " + b.title);
                return;
            }
        }
        System.out.println("\nBook not available.");
    }

    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.isAvailable) {
                b.isAvailable = true;
                System.out.println("\nReturned: " + b.title);
                return;
            }
        }
        System.out.println("\nInvalid return.");
    }

    public static void main(String[] args) {
        Library lib = new Library();

        // 1. Add books
        lib.addBook(new Book(1, "The Alchemist"));
        lib.addBook(new Book(2, "Atomic Habits"));

        // 2. Display all books
        lib.showBooks();

        // 3. Borrow a book
        lib.borrowBook(1);
        lib.showBooks();

        // 4. Return a book
        lib.returnBook(1);
        lib.showBooks();
    }
}
