package com.techelevator.dao;
import com.techelevator.model.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.Date;
import java.util.List;

public class JdbcActivityDao implements ActivityDao {


    @Override
    public List<Activity> getAllReadingActivities() {
        return null;
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

    //TODO
}
