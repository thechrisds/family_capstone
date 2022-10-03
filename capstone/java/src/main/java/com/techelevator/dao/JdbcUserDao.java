package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        return userId;
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToUser(results);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public boolean getParentStatusById(int userId) {
        String sql = "SELECT is_parent FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, boolean.class, userId);
    }

    @Override
    public int findFamilyIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        String sql = "SELECT family_id FROM users WHERE username =?;";
        int familyId;

        try {
            familyId = jdbcTemplate.queryForObject(sql, int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }
        return familyId;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findAllByFamilyId(int id) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public int findFamilyIdByUserId(int userId) {
        //if (userId === null) throw new IllegalArgumentException("User ID cannot be null");
        String sql = "SELECT family_id FROM users WHERE user_id =?;";
        int familyId;

        try {
            familyId = jdbcTemplate.queryForObject(sql, int.class, userId);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User ID " + userId + " was not found.");
        }
        return familyId;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String firstname, String lastname, String password, String role) {
        String insertUserSql = "insert into users (username, firstname, lastname, password_hash,role, is_parent) values (?,?,?,?,?, true)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
        return jdbcTemplate.update(insertUserSql, username, firstname, lastname, password_hash, ssRole) == 1;
    }

    @Override
    public boolean createChild(String username, String firstname, String lastname, String password, String role) {
        String insertUserSql = "insert into users (username, firstname, lastname, password_hash,role, is_parent) values (?,?,?,?,?, false)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
        return jdbcTemplate.update(insertUserSql, username, firstname, lastname, password_hash, ssRole) == 1;
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?;";
        jdbcTemplate.update(sql, userId);
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setTotalMinutes(rs.getInt("total_minutes"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }
    /*
    private User mapRowToUserTwo(SqlRowSet rs) {
        User user = new User();
        return user;
    }

     */
}
