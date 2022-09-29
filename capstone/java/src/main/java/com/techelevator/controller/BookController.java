package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;
    private UserDao userDao;


    public BookController(BookDao bookDao, UserDao userDao){
        this.userDao = userDao;
        this.bookDao = bookDao;
    }


    @RequestMapping(value = "/books/all", method = RequestMethod.GET)
    public List<Book> getPublicBooks(){
        List<Book> bookList = new ArrayList<>();
        return bookList = bookDao.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book, Principal principal) throws Exception {
        book.setFamilyId(userDao.findFamilyIdByUsername(principal.getName()));
        if (!bookDao.addBook(book.getBookTitle(), book.getBookAuthor(), book.getIsbn(), book.getGenre(), book.getDescription(), book.getFamilyId())){
            throw new Exception("Adding book failed. Make sure no duplicate title or ISBN exists");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int isbn) throws Exception { //can be isbn or book id technically
//        if (!bookDao.deleteBook(isbn)){
//            throw new Exception("Error deleting book.");
//        }         Not working how I want it to
        bookDao.deleteBook(isbn);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(Principal principal){
        List<Book> bookList = new ArrayList<>();
        int familyId = userDao.findFamilyIdByUsername(principal.getName());
        return bookList = bookDao.findBooksByFamilyId(familyId);
    }


}
