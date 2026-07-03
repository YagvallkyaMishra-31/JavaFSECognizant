package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

/**
 * BookService - Contains the business logic for managing books.
 *
 * This class depends on BookRepository to access the data layer.
 * Instead of creating the repository ourselves (like: new BookRepository()),
 * we let Spring inject it for us through the setter method.
 *
 * This is "Dependency Injection" — the framework handles creating objects
 * and wiring them together, so our classes stay loosely coupled.
 *
 * Exercise 2 specifically asks for setter-based injection, which is why
 * we have the setBookRepository() method below. Spring calls this method
 * automatically based on what we define in applicationContext.xml.
 */
public class BookService {

    // This dependency will be injected by Spring via the setter method
    private BookRepository bookRepository;

    /**
     * Setter method for dependency injection.
     * Spring uses this to inject the BookRepository bean.
     * This is called "setter injection" — one of the two main DI approaches
     * (the other being constructor injection).
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] BookRepository has been injected via setter.");
    }

    /**
     * Retrieves all books from the repository and displays them.
     */
    public List<String> getAllBooks() {
        System.out.println("\n--- All Books in Library ---");
        List<String> books = bookRepository.findAllBooks();
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("Total books: " + books.size());
        return books;
    }

    /**
     * Adds a new book through the repository.
     */
    public void addBook(String book) {
        bookRepository.addBook(book);
    }

    /**
     * Removes a book from the library.
     */
    public void removeBook(String book) {
        bookRepository.removeBook(book);
    }

    /**
     * Searches for books by keyword.
     */
    public List<String> searchBooks(String keyword) {
        System.out.println("\n--- Search Results for: \"" + keyword + "\" ---");
        List<String> results = bookRepository.searchBooks(keyword);
        if (results.isEmpty()) {
            System.out.println("No books found matching \"" + keyword + "\"");
        } else {
            for (String book : results) {
                System.out.println("  -> " + book);
            }
        }
        return results;
    }
}
