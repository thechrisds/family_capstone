package com.techelevator.dao;

import com.techelevator.model.Prize;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcPrizeDao implements PrizeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPrizeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Prize> findPrizesByFamilyId(int familyId) {
        List<Prize> prizeList = new ArrayList<>();
        String sql = "SELECT * FROM prizes";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Prize prize = mapRowToPrize(results);
            prizeList.add(prize);
        }


        return prizeList;
    }

    @Override
    public Prize addPrize(int familyId, String name, String description, int goal, int stock, Date start_date, Date end_date) {
        return null;
    }

    @Override
    public void updatePrize(Prize prize) {

    }

    @Override
    public List<Prize> findExpiredPrizesFamilyId(int familyId) {
        return null;
    }

    @Override
    public void deletePrize(int prizeId) {

    }

    @Override
    public List<Prize> findActivePrizes(int familyId) {
        return null;
    }

    private Prize mapRowToPrize(SqlRowSet rs){
        Prize prize = new Prize();
        prize.setFamily_id(rs.getInt("family_id"));
        prize.setPrize_id(rs.getInt("prizes_id"));
        prize.setName(rs.getString("name"));
        prize.setDescription(rs.getString("description"));
        prize.setGoal(rs.getInt("eligible"));
        prize.setStock(rs.getInt("stock"));
        prize.setStart_date(rs.getDate("start_date"));
        prize.setEnd_date(rs.getDate("end_date"));
        return prize;
    }
}
