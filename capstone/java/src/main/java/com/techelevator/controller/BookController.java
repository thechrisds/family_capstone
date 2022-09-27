package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;

    public BookController(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(){
        List<Book> bookList = new ArrayList<>();
        return bookList = bookDao.findAll();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) throws Exception {
        if (!bookDao.addBook(book.getBookTitle(), book.getBookAuthor(), book.getIsbn(), book.getGenre(), book.getDescription())){
            throw new Exception("Adding book failed. Make sure no duplicate title or ISBN exists");
        }
    }

    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int isbn) throws Exception { //can be isbn or book id technically
//        if (!bookDao.deleteBook(isbn)){
//            throw new Exception("Error deleting book.");
//        }         Not working how I want it to
        bookDao.deleteBook(isbn);


    }


}
