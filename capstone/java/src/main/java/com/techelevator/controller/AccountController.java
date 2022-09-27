package com.techelevator.controller;


import com.techelevator.dao.AccountDao;
import com.techelevator.dao.UserDao;
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
public class AccountController {
    @Autowired
    private AccountDao accountDao;
    private UserDao userDao;

    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    public AccountController() {
    }

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public List<User> getAllByFamilyId(@PathVariable int id) {
        return userDao.findAllByFamilyId(id);
    }

    //@RequestMapping(path = "/account/{id}", method = RequestMethod.POST)

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public void createNewChildUser(@Valid @RequestBody RegisterUserDTO newUser, LoginDTO loginDto) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new UserAlreadyExistsException();
        } catch (UsernameNotFoundException e) {
            String role = "ROLE_USER";
            userDao.createChild(newUser.getUsername(),newUser.getPassword(), role);
            accountDao.updateFamilyId(loginDto.getUsername(), newUser.getUsername());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public void createNewParentUser(@Valid @RequestBody RegisterUserDTO newUser, LoginDTO loginDto) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new UserAlreadyExistsException();
        } catch (UsernameNotFoundException e) {
            String role = "ROLE_USER";
            userDao.create(newUser.getUsername(),newUser.getPassword(), role);
            accountDao.updateFamilyId(loginDto.getUsername(), newUser.getUsername());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/account/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        accountDao.deleteUser(id);
    }

}
