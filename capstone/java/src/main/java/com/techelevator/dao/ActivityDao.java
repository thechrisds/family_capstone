package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityDao {

    List<Activity> getAllReadingActivities();
    Activity getActivityByActivityId(int activityId);
    List<Activity> getActivitiesByReaderId(int readerId);
    List<Activity> getActivitiesByFamilyId(int familyId);
    int getTotalReadingMinutesByReaderId(int readerId);
    int getReaderMinutesByDate(Date dateRead);
    Boolean addActivity(Activity activityToAdd);
    void updateActivity(Activity activityToUpdate, int activityId);
    void deleteActivity(int activityId);

    //TODO
}
