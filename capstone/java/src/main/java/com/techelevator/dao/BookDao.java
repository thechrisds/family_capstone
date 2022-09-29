package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    Book findBookByTitle(String title);

    Book findBookByAuthor(String author);

    Book findBookByISBN(long isbn);

    List<Book> findAll();

    List<Book> findBookByFamilyId(int familyId);

    List<Book> findBookByGenre(String genre);

    List<Book> findBookByType(String bookType);

    //boolean addBook(String bookTitle, String bookAuthor, int isbn, String bookType, String genre, String description);
    //db doesn't inclue bookType yet, quick/simple fix
    boolean addBook(String bookTitle, String bookAuthor, long isbn, String genre, String description);

    boolean deleteBook(long isbn); //delete via isbn? idk

}
