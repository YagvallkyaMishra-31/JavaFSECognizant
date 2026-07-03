package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryManagementApplication - Main class to run the Spring application.
 *
 * This class demonstrates:
 *   Exercise 1: Loading the Spring ApplicationContext from XML configuration
 *   Exercise 2: Using dependency injection — BookService automatically gets
 *               BookRepository injected by Spring, we don't create it manually
 *
 * How it works:
 * 1. We load the applicationContext.xml file using ClassPathXmlApplicationContext
 * 2. Spring reads the XML and creates all the beans defined in it
 * 3. Spring also handles wiring — it injects BookRepository into BookService
 * 4. We just ask Spring for the BookService bean and use it
 *
 * This is the power of Inversion of Control (IoC) — we don't manage object
 * creation or dependencies ourselves, Spring does it for us.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Library Management Application ===\n");
        System.out.println("Loading Spring Application Context...\n");

        // Load the Spring context from our XML configuration file
        // Spring will create all beans and inject dependencies at this point
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nSpring context loaded successfully!\n");

        // Get the BookService bean from Spring container
        // Notice we don't use "new BookService()" — Spring manages it
        BookService bookService = context.getBean("bookService", BookService.class);

        // Test 1: List all books (should show the 4 default ones from BookRepository)
        bookService.getAllBooks();

        // Test 2: Add a new book
        System.out.println();
        bookService.addBook("The Alchemist - Paulo Coelho");

        // Test 3: List again to confirm the new book was added
        bookService.getAllBooks();

        // Test 4: Search for a book by keyword
        bookService.searchBooks("Kill");

        // Test 5: Search for something that doesn't exist
        bookService.searchBooks("Harry Potter");

        // Test 6: Remove a book
        System.out.println();
        bookService.removeBook("1984 - George Orwell");

        // Test 7: Final listing
        bookService.getAllBooks();

        System.out.println("\n=== Application finished ===");

        // Close the context to release resources
        ((ClassPathXmlApplicationContext) context).close();
    }
}
