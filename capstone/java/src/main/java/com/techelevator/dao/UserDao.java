package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String firstname, String lastname, String password, String role);

    List<User> findAllByFamilyId(int id);

    int findFamilyIdByUsername(String username);

    boolean createChild(String username, String firstname, String lastname, String password, String role);

    void deleteUser(int userId);

    int findFamilyIdByUserId(int userId);

    boolean getParentStatusById(int userId);
}
