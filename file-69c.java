// Imports
import java.util.Scanner;
import java.util.ArrayList;

// LibrarySystem class
public class LibrarySystem {

    // Array list for storing book objects
    private ArrayList<Book> books;

    // LibrarySystem constructor
    public LibrarySystem() {
        books = new ArrayList<>();
    }

    // Book class
    public class Book {
        private String title;
        private String author;
        private boolean isAvailable;

        // Book constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }
    }

    // Add book method
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove book method
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Find book by title method
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Check out book method
    public void checkOutBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Sorry, that book is not available.");
        }
    }

    // Check in book method
    public void checkInBook(Book book) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book checked in successfully.");
        } else {
            System.out.println("This book is already available.");
        }
    }

    // Main method
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Add books
        librarySystem.addBook(librarySystem.new Book("The Catcher in the Rye", "J.D. Salinger"));
        librarySystem.addBook(librarySystem.new Book("To Kill a Mockingbird", "Harper Lee"));

        // Check out a book
        System.out.print("Enter the title of the book you would like to check out: ");
        String title = scanner.nextLine();
        Book book = librarySystem.findBookByTitle(title);
        if (book != null) {
            librarySystem.checkOutBook(book);
        } else {
            System.out.println("Sorry, that book is not in our library.");
        }

        // Check in a book
        System.out.print("Enter the title of the book you would like to check in: ");
        title = scanner.nextLine();
        book = librarySystem.findBookByTitle(title);
        if (book != null) {
            librarySystem.checkInBook(book);
        } else {
            System.out.println("Sorry, that book is not in our library.");
        }
    }
}