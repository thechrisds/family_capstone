package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityDao {

    boolean createActivity(Activity activity);
    boolean deleteActivity(int activityId);
    List<Activity> getAllReadingActivities();
    Activity getActivityByActivityId(int activityId);
    List<Activity> getActivitiesByReaderId(int readerId);
    List<Activity> getActivitiesByFamilyId(int familyId);
    int getTotalReadingMinutesByReaderId(int readerId);


    //TODO
}
