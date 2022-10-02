package com.techelevator.dao;

import com.techelevator.model.Activity;


import java.util.List;

public interface ActivityDao {

    void createActivity(Activity activity);
    void deleteActivity(int activityId);
    List<Activity> getActivitiesByCurrentUser(int readerId);
    List<Activity> getAllReadingActivities();
    Activity getActivityByActivityId(int activityId);
    List<Activity> getActivitiesByReaderId(int readerId);
    List<Activity> getActivitiesByFamilyId(int familyId);
    int getTotalReadingMinutesByReaderId(int readerId);
    int getTotalReadingMinutesByFamily(int familyId);

}
