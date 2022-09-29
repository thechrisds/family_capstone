package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }


    @Override
    public Book findBookByTitle(String title) {
        Book book = null;
        String sql = "SELECT * FROM library WHERE book_title = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
        if (results.next()){
            book = mapRowToBook(results);
        }
        return book;
    }

    @Override
    public Book findBookByAuthor(String author) {
        Book book = null;
        String sql = "SELECT * FROM library WHERE book_author = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, author);
        if (results.next()){
            book = mapRowToBook(results);
        }
        return book;
    }

    @Override
    public Book findBookByISBN(long isbn) {
        Book book = null;
        String sql = "SELECT * FROM library WHERE isbn = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, isbn);
        if (results.next()){
            book = mapRowToBook(results);
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM library";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Book book = mapRowToBook(results);
            bookList.add(book);
        }


        return bookList;
    }

    @Override
    public List<Book> findBooksByFamilyId(int familyId){
        Book book = null;
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM library WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while (results.next()){
            book = mapRowToBook(results);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> findBooksByGenre(String genre) {
        Book book = null;
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM library WHERE book_genre = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre);
        while (results.next()){
            book = mapRowToBook(results);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> findBooksByType(String bookType) {
        List<Book> bookList = new ArrayList<>();
        Book book = null;
        String sql = "SELECT * FROM library WHERE book_type = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookType);
        while(results.next()){
            book = mapRowToBook(results);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public boolean addBook(String bookTitle, String bookAuthor, long isbn, String genre, String description, int family_id) {
        String sql = "INSERT INTO library (book_title, book_author, isbn, genre, description, family_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, bookTitle, bookAuthor, isbn, genre, description, family_id);
        } catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBook(long isbn) {
        boolean success = true;
        String a = "";
        a += isbn;
        String sql;

        List<Book> bookList = findAll();
        for (Book i : bookList){
            if (i.getBookID() == isbn){
                sql = "DELETE FROM library WHERE book_id = ?";
                jdbcTemplate.update(sql, isbn);
            } else if (i.getIsbn() == isbn){
                sql = "DELETE FROM library WHERE isbn = ?";
            } else {
                success = false;
            }
        }
        return success;
    }

    private Book mapRowToBook(SqlRowSet results){
        Book book = new Book();
        book.setBookID(results.getInt("book_id"));
        book.setIsbn(results.getLong("isbn"));
        book.setBookTitle(results.getString("book_title"));
        book.setBookAuthor(results.getString("book_author"));
        book.setCoverImg(results.getString("cover_img"));
        book.setGenre(results.getString("genre"));
        book.setDescription(results.getString("description"));
        book.setFamilyId(results.getInt("family_id"));


        return book;
    }

}
