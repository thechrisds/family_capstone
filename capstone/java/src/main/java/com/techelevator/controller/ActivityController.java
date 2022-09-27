package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ActivityController {
    @Autowired
    private ActivityDao ActivityDao;
    private UserDao userDao;

    public ActivityController(ActivityDao ActivityDao, UserDao userDao) {
        this.ActivityDao = ActivityDao;
        this.userDao = userDao;
    }

    public ActivityController() {
    }


    //TODO
}
