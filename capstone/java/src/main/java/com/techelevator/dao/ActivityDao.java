package com.techelevator.dao;

import com.techelevator.model.Activity;
import com.techelevator.model.DetailedActivity;

import java.util.Date;
import java.util.List;

public interface ActivityDao {

    List<Activity> getAllReadingActivities();
    Activity getActivityByActivityId(int activityId);
    List<DetailedActivity> getActivitiesByReaderId(int readerId);
    List<DetailedActivity> getActivitiesByFamilyId(int familyId);
    int getTotalReadingMinutesByReaderId(int readerId);
//    Boolean addActivity(Activity activityToAdd);
//    void updateActivity(Activity activityToUpdate, int activityId);
//    void deleteActivity(int activityId);

    //TODO
}
