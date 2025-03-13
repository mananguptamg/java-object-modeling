import java.util.ArrayList;

// Representing a single book with attributes: title and author.
class Book {
    private String title;
    private String author;

    // Constructor for creating a book object.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter for title.
    public String getTitle() {
        return title;
    }

    // Setter for title.
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for author.
    public String getAuthor() {
        return author;
    }

    // Setter for author.
    public void setAuthor(String author) {
        this.author = author;
    }

    // Override toString for easy display of book details.
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

// Representing a library as a collection of Book objects (Aggregation).
class Library {
    private String name;
    private ArrayList<Book> books;

    // Constructor for creating a library object.
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add a book to the library's collection.
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the library's collection.
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Get all books from the library's collection.
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Get library name.
    public String getName() {
        return name;
    }

    // Set library name.
    public void setName(String name) {
        this.name = name;
    }

    // Display details of all books in the library.
    public void displayBooks() {
        System.out.println("Library: " + name);
        books.forEach(System.out::println);
    }
}

// Demonstrate the Library and Book classes to model Aggregation.
public class LibraryBooksManagement {
    public static void main(String[] args) {
        // Create independent book objects.
        Book book1 = new Book("Core Java", "James");
        Book book2 = new Book("OOP Java", "Gosling");
        Book book3 = new Book("Advance Java", "James Gosling");

        // Create library objects.
        Library library1 = new Library("City Library");
        Library library2 = new Library("College Library");

        // Add books to the libraries.
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

        // Display books in each library.
        library1.displayBooks();
        library2.displayBooks();

        // Remove a book and show updated collections.
        library1.removeBook(book1);
        System.out.println("\nAfter removing a book from City Library:");
        library1.displayBooks();
    }
}

