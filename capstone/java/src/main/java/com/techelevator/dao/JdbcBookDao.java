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
        String sql = "SELECT * FROM library WHERE family_id = ? AND deleted = false";
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
    public void deleteBook(Book book) {
        String sql = "UPDATE library SET isbn = ?, book_title = ?, book_author = ?, genre = ?, description = ?, deleted = ? WHERE book_id = ?";
        book.setDeleted(true);
        jdbcTemplate.update(sql, book.getIsbn(), book.getBookTitle(), book.getBookAuthor(), book.getGenre(), book.getDescription(), book.isDeleted(), book.getBookID());


    }

    @Override
    public void editBook(Book book){
        String sql = "UPDATE library SET isbn = ?, book_title = ?, book_author = ?, genre = ?, description = ? WHERE book_id = ?";
        jdbcTemplate.update(sql, book.getIsbn(), book.getBookTitle(), book.getBookAuthor(), book.getGenre(), book.getDescription(), book.getBookID());
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
        book.setDeleted(results.getBoolean("deleted"));


        return book;
    }

}
