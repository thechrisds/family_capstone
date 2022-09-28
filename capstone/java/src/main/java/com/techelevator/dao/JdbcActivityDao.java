package com.techelevator.dao;
import com.techelevator.model.Activity;
import com.techelevator.model.DetailedActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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
    public List<DetailedActivity> getActivitiesByReaderId(int readerId) {
        List<DetailedActivity> activityList = new ArrayList<>();
        String sql = "SELECT u.username, b.book_title, a.date_read, a.minutes_read, a.completed, a.notes FROM reading_activity a JOIN users u ON a.user_id = u.user_id JOIN library b ON a.isbn = b.isbn WHERE a.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, readerId);
        while (results.next()) {
            activityList.add(mapResultsToDetailedActivity(results));
        }
        return activityList;
    }

    @Override
    public List<DetailedActivity> getActivitiesByFamilyId(int familyId) {
        List<DetailedActivity> activityList = new ArrayList<>();
        String sql = "SELECT u.username, b.book_title, a.date_read, a.minutes_read, a.completed, a.notes \n" +
                "FROM reading_activity a \n" +
                "JOIN users u ON a.user_id = u.user_id \n" +
                "JOIN library b ON a.isbn = b.isbn\n" +
                "WHERE a.user_id IN (SELECT user_id FROM users WHERE family_id = ?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while (results.next()) {
            activityList.add(mapResultsToDetailedActivity(results));
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

    @Override
    public Boolean addActivity(Activity activityToAdd) {
        return true;
    }

    @Override
    public void updateActivity(Activity activityToUpdate, int activityId) {

    }

    @Override
    public void deleteActivity(int activityId) {

    }

    private Activity mapResultsToActivity(SqlRowSet results) {
        int activityId = results.getInt("activity_id");
        int bookId = results.getInt("isbn");
        int readerId = results.getInt("user_id");
        Date dateRead = results.getDate("date_read");
        int timeInMinutes = results.getInt("minutes_read");
        String activityNotes = results.getString("notes");
        boolean isComplete = results.getBoolean("completed");
        String format = results.getString("format");
        Activity activity = new Activity(activityId,bookId,readerId,dateRead,timeInMinutes,activityNotes,isComplete,format);
        return activity;
    }

    private DetailedActivity mapResultsToDetailedActivity(SqlRowSet results) {
        String userName = results.getString("username");
        String bookTitle = results.getString("book_title");
        Date dateRead = results.getDate("date_read");
        int timeInMinutes = results.getInt("minutes_read");
        boolean isComplete = results.getBoolean("completed");
        String activityNotes = results.getString("notes");
        DetailedActivity detailedActivity = new DetailedActivity(userName,bookTitle,dateRead,timeInMinutes,isComplete,activityNotes);
        return detailedActivity;
    }
    //TODO
}
