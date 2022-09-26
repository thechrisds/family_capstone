package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
