package com.techelevator.dao;
import com.techelevator.model.Activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcActivityDao implements ActivityDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    BookDao bookDao;

    public JdbcActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createActivity(Activity activity){
        String sql = "INSERT INTO reading_activity(user_id, isbn, minutes_read) " +
                "VALUES(?, ?, ?)";
        try {
            jdbcTemplate.update(sql, activity.getReaderId(), activity.getIsbn(), activity.getTimeInMinutes());
        } catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteActivity(int activityId){
        String sql = "DELETE FROM reading_activity WHERE activity_id = ?";
        try {
            jdbcTemplate.update(sql, activityId);
        } catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public List<Activity> getAllReadingActivities() {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT * FROM reading_activity;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            activityList.add(mapResultsToActivity(results));
        }
        return activityList;
    }



    @Override
    public Activity getActivityByActivityId(int activityId) {
        Activity activity = null;
        String sql = "SELECT * FROM reading_activity WHERE activity_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, activityId);
        if (result.next()) {
            activity = mapResultsToActivity(result);
        }
        return activity;
    }

    @Override
    public List<Activity> getActivitiesByReaderId(int readerId) {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT u.username, b.book_title, a.date_read, a.minutes_read, a.completed, a.notes FROM reading_activity a JOIN users u ON a.user_id = u.user_id JOIN library b ON a.isbn = b.isbn WHERE a.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, readerId);
        while (results.next()) {
            activityList.add(mapResultsToActivity(results));
        }
        return activityList;
    }

    @Override
    public List<Activity> getActivitiesByFamilyId(int familyId) {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT u.username, b.book_title, a.date_read, a.minutes_read, a.completed, a.notes \n" +
                "FROM reading_activity a \n" +
                "JOIN users u ON a.user_id = u.user_id \n" +
                "JOIN library b ON a.isbn = b.isbn\n" +
                "WHERE a.user_id IN (SELECT user_id FROM users WHERE family_id = ?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while (results.next()) {
            activityList.add(mapResultsToActivity(results));
        }
        return activityList;
    }

    @Override
    public int getTotalReadingMinutesByReaderId(int readerId) {
        String sql = "SELECT SUM(minutes_read) FROM reading_activity WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, readerId);
        if (result.next()) {
            return result.getInt("sum");
        }
        return 0;
    }

    private Activity mapResultsToActivity(SqlRowSet results) {
        int activityId = results.getInt("activity_id");
        int readerId = results.getInt("user_id");
        long isbn = results.getInt("isbn");
        String format = results.getString("format");
        Date dateRead = results.getDate("date_read");
        int timeInMinutes = results.getInt("minutes_read");
        String activityNotes = results.getString("notes");
        boolean isComplete = results.getBoolean("completed");
        return new Activity(activityId,readerId,isbn,format,dateRead,timeInMinutes,activityNotes,isComplete);
    }


    //TODO
}
