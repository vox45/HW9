import java.util.ArrayList;

class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void printBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author + ", Year: " + book.publicationYear);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів книг та бібліотеки
        Book book1 = new Book("Title1", "Author1", 2020);
        Book book2 = new Book("Title2", "Author2", 2018);
        Book book3 = new Book("Title3", "Author3", 2022);

        Library library = new Library();

        // Додавання книг до бібліотеки
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Виведення списку книг у бібліотеці
        library.printBooks();

        // Видалення книги з бібліотеки
        library.removeBook(book2);

        // Виведення оновленого списку книг у бібліотеці
        library.printBooks();
    }
}
