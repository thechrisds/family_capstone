package com.techelevator.dao;
import com.techelevator.model.Activity;
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
        return null;
    }

    @Override
    public List<Activity> getActivitiesByReaderId(int readerId) {
        return null;
    }

    @Override
    public List<Activity> getActivitiesByFamilyId(int familyId) {
        return null;
    }

    @Override
    public int getTotalReadingMinutesByReaderId(int readerId) {
        return 0;
    }

    @Override
    public int getReaderMinutesByDate(Date dateRead) {
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

        Activity activity = new Activity(activityId,bookId,readerId,dateRead,timeInMinutes,activityNotes,isComplete);

        return activity;
    }
    //TODO
}
