package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    Activity getActivityByActivityId (int activityId);

    List<Activity> getActivityByUserId (int userId);

    List<Activity> getActivityByFamilyId (int familyId);

    Activity createActivity(Activity activity);

    int getTotalReadingTimeByFamilyId (int familyId);

    int getTotalReadingTimeByUserId (int userId);

    //get by date range?
    //reading a book by minutes read?
    //
}
