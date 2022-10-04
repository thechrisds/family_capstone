package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    Book findBookByTitle(String title);

    Book findBookByAuthor(String author);

    Book findBookByISBN(long isbn);

    List<Book> findAll();

    List<Book> findBooksByFamilyId(int familyId);

    List<Book> findBooksByGenre(String genre);

    List<Book> findBooksByType(String bookType);

    //boolean addBook(String bookTitle, String bookAuthor, int isbn, String bookType, String genre, String description);
    //db doesn't inclue bookType yet, quick/simple fix

    boolean addBook(String bookTitle, String bookAuthor, long isbn, String genre, String description, int family_id);

    void deleteBook(Book book); //delete via isbn? idk

    void editBook(Book book);
}
