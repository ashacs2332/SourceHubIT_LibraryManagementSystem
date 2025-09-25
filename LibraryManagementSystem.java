package learn;

import java.util.ArrayList;
import java.util.Scanner;


class Book {
    int id;
    String title;
    String author;
    int quantity;

    
    Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    
    void display() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Quantity: " + quantity);
    }
}


class Library {
    ArrayList<Book> books = new ArrayList<>();

    
    void addBook(Book book) {
        books.add(book);
        System.out.println(" Book added successfully!");
    }

   
    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available.");
            return;
        }
        System.out.println("\n Available Books:");
        for (Book b : books) {
            b.display();
        }
    }

 
    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.quantity > 0) {
                    b.quantity--;
                    System.out.println(" Book issued successfully!");
                } else {
                    System.out.println(" Book not available (Out of stock).");
                }
                return;
            }
        }
        System.out.println(" Book not found.");
    }

    
    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                b.quantity++;
                System.out.println(" Book returned successfully!");
                return;
            }
        }
        System.out.println(" Book not found.");
    }

 
    void searchById(int id) {
        for (Book b : books) {
            if (b.id == id) {
                System.out.println(" Book found:");
                b.display();
                return;
            }
        }
        System.out.println(" Book not found.");
    }

   
    void searchByTitle(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println(" Book found:");
                b.display();
                return;
            }
        }
        System.out.println(" Book not found.");
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n........Library Menu........");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by ID");
            System.out.println("6. Search Book by Title");
            System.out.println("7. Exit");
            System.out.print(" Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    Book book = new Book(id, title, author, qty);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.print("Enter Book ID to Search: ");
                    int searchId = sc.nextInt();
                    library.searchById(searchId);
                    break;

                case 6:
                    System.out.print("Enter Book Title to Search: ");
                    String searchTitle = sc.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println(" Invalid choice. Try again!");
            }
        }
    }
}
