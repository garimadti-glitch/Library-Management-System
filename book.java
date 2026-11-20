import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple Book class example without using Scanner.
 */
public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : ₹" + price);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Read book title
            System.out.print("Enter book title: ");
            String title = reader.readLine();

            // Read book author
            System.out.print("Enter book author: ");
            String author = reader.readLine();

            // Read book price
            System.out.print("Enter book price: ");
            String priceInput = reader.readLine();
            double price;
            try {
                price = Double.parseDouble(priceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Setting to 0.0");
                price = 0.0;
            }

            // Create Book object and display details
            Book book = new Book(title, author, price);
            book.displayDetails();

        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
