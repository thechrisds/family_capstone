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
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountDao accountDao;
    private UserDao userDao;

    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public List<User> getAllByFamilyId(@PathVariable int id) {
        return userDao.findAllByFamilyId(id);
    }

    @RequestMapping(path = "/account/username/{username}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public int getFamilyIdByUsername(@PathVariable String username) {
        return userDao.findFamilyIdByUsername(username);
    }

    @RequestMapping(path = "/account/userid/{familyid}", method = RequestMethod.GET)
    public int getFamilyIdByUserId(@PathVariable int userId) {
        return userDao.findFamilyIdByUserId(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/account/newChild", method = RequestMethod.POST)
    public void createNewChildUser(@Valid @RequestBody RegisterUserDTO newUser, Principal principal) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new UserAlreadyExistsException();
        } catch (UsernameNotFoundException e) {
            String role = "ROLE_USER";
            userDao.create(newUser.getUsername(),newUser.getFirstname(), newUser.getLastname(), newUser.getPassword(), role);
            accountDao.updateFamilyId(principal.getName(), newUser.getUsername());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/account/newParent", method = RequestMethod.POST)
    public void createNewParentUser(@Valid @RequestBody RegisterUserDTO newUser, LoginDTO loginDto) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new UserAlreadyExistsException();
        } catch (UsernameNotFoundException e) {
            String role = "ROLE_USER";
            userDao.create(newUser.getUsername(),newUser.getPassword(), newUser.getFirstname(), newUser.getLastname(), role);
            accountDao.updateFamilyId(loginDto.getUsername(), newUser.getUsername());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/account/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        boolean result = userDao.getParentStatusById(id);
        
            accountDao.deleteUser(id);

    }

}
