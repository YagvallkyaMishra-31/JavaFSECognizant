package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * BookRepository - Handles the data layer for books.
 *
 * In a real application, this would connect to a database.
 * For now, we're using a simple in-memory list to simulate storage.
 * The important thing here is how Spring manages this class as a bean
 * and injects it into BookService.
 */
public class BookRepository {

    // Simulating a database with an in-memory list
    private List<String> books;

    public BookRepository() {
        books = new ArrayList<>();
        // adding some default books so we have data to work with
        books.add("The Great Gatsby - F. Scott Fitzgerald");
        books.add("To Kill a Mockingbird - Harper Lee");
        books.add("1984 - George Orwell");
        books.add("Pride and Prejudice - Jane Austen");
        System.out.println("[BookRepository] Initialized with " + books.size() + " books.");
    }

    /**
     * Returns all books in the repository.
     */
    public List<String> findAllBooks() {
        return new ArrayList<>(books); // return a copy so the original list stays safe
    }

    /**
     * Adds a new book to the repository.
     */
    public void addBook(String book) {
        books.add(book);
        System.out.println("[BookRepository] Added: " + book);
    }

    /**
     * Removes a book from the repository by title.
     * Returns true if the book was found and removed.
     */
    public boolean removeBook(String book) {
        boolean removed = books.remove(book);
        if (removed) {
            System.out.println("[BookRepository] Removed: " + book);
        } else {
            System.out.println("[BookRepository] Book not found: " + book);
        }
        return removed;
    }

    /**
     * Searches for books that contain the given keyword in their title.
     */
    public List<String> searchBooks(String keyword) {
        List<String> results = new ArrayList<>();
        for (String book : books) {
            if (book.toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
}
