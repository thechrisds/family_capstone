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

    public JdbcActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void createActivity(Activity activity){
        String sql = "INSERT INTO reading_activity(user_id, isbn, minutes_read, notes) " +
                "VALUES(?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, activity.getReaderId(), activity.getIsbn(), activity.getTimeInMinutes(), activity.getActivityNotes());
        } catch (DataAccessException e){
            System.out.println("creation failed");
        }
    }

    @Override
    public void deleteActivity(int activityId){
        String sql = "DELETE FROM reading_activity WHERE activity_id = ?";
        try {
            jdbcTemplate.update(sql, activityId);
        } catch (DataAccessException e){
            System.out.println("deletion failed");
        }
    }

    @Override
    public List<Activity> getAllReadingActivities() {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT a.activity_id, a.user_id, u.username, a.isbn, b.book_title, a.format_id, a.date_read,  a.minutes_read, a.notes, a.completed FROM reading_activity a JOIN users u ON a.user_id = u.user_id JOIN library b ON a.isbn = b.isbn;";
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
        String sql = "SELECT a.activity_id, a.user_id, u.username, a.isbn, b.book_title, a.format_id, a.date_read,  a.minutes_read, a.notes, a.completed FROM reading_activity a JOIN users u ON a.user_id = u.user_id JOIN library b ON a.isbn = b.isbn WHERE a.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, readerId);
        while (results.next()) {
            activityList.add(mapResultsToActivity(results));
        }
        return activityList;
    }


    @Override
    public List<Activity> getActivitiesByFamilyId(int familyId) {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT a.activity_id, a.user_id, u.username, a.isbn, b.book_title, a.format_id, a.date_read,  a.minutes_read, a.notes, a.completed\n" +
                "                FROM reading_activity a\n" +
                "                JOIN users u ON a.user_id = u.user_id \n" +
                "                JOIN library b ON a.isbn = b.isbn\n" +
                "                WHERE a.user_id IN (SELECT user_id FROM users WHERE family_id = ?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while (results.next()) {
            activityList.add(mapResultsToActivity(results));
        }
        return activityList;
    }

    @Override
    public List<Activity> getActivitiesByCurrentUser(int readerId) {
        List<Activity> activityList = new ArrayList<>();
        String sql = "SELECT a.activity_id, a.user_id, u.username, a.isbn, b.book_title, a.format_id, a.date_read,  a.minutes_read, a.notes, a.completed\n" +
                "                FROM reading_activity a\n" +
                "                JOIN users u ON a.user_id = u.user_id \n" +
                "                JOIN library b ON a.isbn = b.isbn\n" +
                "                WHERE a.user_id IN (SELECT user_id FROM users WHERE user_id = ?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, readerId);
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
        String userName = results.getString("username");
        long isbn = results.getLong("isbn");
        String bookTitle = results.getString("book_title");
        int formatId = results.getInt("format_id");
        Date dateRead = results.getDate("date_read");
        int timeInMinutes = results.getInt("minutes_read");
        String activityNotes = results.getString("notes");
        boolean isComplete = results.getBoolean("completed");
        return new Activity(activityId,readerId,userName,isbn,bookTitle,formatId,dateRead,timeInMinutes,activityNotes,isComplete);
    }
}
