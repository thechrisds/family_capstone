package com.techelevator.dao;
import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcAccountDao() {
    }

    @Override
    public Boolean create(String familyName) {
        String sql = "INSERT INTO family_account " +
                "(family_name) " +
                "VALUES(?) " +
                "RETURNING family_id;" +

                "UPDATE users " +
                "SET family_id = (SELECT family_id FROM family_account WHERE family_name = ? " +
                "WHERE username = ?;";
        jdbcTemplate.queryForObject(sql, Integer.class, familyName, familyName, familyName);
        return true;
    }

    @Override
    public void updateFamilyName(String familyName, int familyId) {
        String sql = "UPDATE family_account " +
                "SET family_name = ? " +
                "WHERE family_id = ?;";
        jdbcTemplate.update(sql, familyName, familyId);
    }

    @Override
    public void updateFamilyId(String parent, String username) {
        String sql = "UPDATE users " +
                "SET family_id = (SELECT family_id FROM users WHERE username = ?) " +
                "WHERE username = ?;";
        jdbcTemplate.update(sql, parent, username);
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE users_id = ?;";
        jdbcTemplate.update(sql, userId);

    }



    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();
        account.setFamilyId(rowSet.getInt("family_id"));
        account.setFamilyName(rowSet.getString("family_name"));
        return account;
    }

}
