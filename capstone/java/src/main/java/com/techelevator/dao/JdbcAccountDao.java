package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();

        account.setFamilyId(rowSet.getInt("family_id"));
        account.setFamilyName(rowSet.getString("family_name"));
        return account;
    }

    public JdbcAccountDao() {
    }


    @Override
    public boolean create(String familyName) {
        return false;
    }

    @Override
    public void updateFamilyName(String familyName) {

    }

    @Override
    public Account getUserByAccount(String username) {
        return null;
    }

    @Override
    public Account getAllUsersByAccount(int familyId) {
        return null;
    }
}
