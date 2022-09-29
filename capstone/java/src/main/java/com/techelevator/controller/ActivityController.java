package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    public ActivityController(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @RequestMapping(path = "/activity/", method = RequestMethod.POST)
    public void createActivity(@RequestBody Activity activity) throws Exception {
        try {
            activityDao.createActivity(activity);
        } catch (DataAccessException e){
            throw new Exception("Adding activity failed.");
        }
    }

    @RequestMapping(path = "/activity", method = RequestMethod.GET)
    public List<Activity> returnAllActivity() {
        List<Activity> allActivity = activityDao.getAllReadingActivities();
        return allActivity;
    }

    @RequestMapping(path = "/activity/{activityId}", method = RequestMethod.GET)
    public Activity returnActivityByActivityId(@PathVariable int activityId) {
        Activity activity = activityDao.getActivityByActivityId(activityId);
        return activity;
    }

    @RequestMapping(path = "/activity/rid/{readerId}", method = RequestMethod.GET)
    public List<Activity> returnActivityByReaderId(@PathVariable int readerId) {
        List<Activity> activityByUser = activityDao.getActivitiesByReaderId(readerId);
        return activityByUser;
    }

    @RequestMapping(path = "/activity/fid/{familyId}", method = RequestMethod.GET)
    public List<Activity> returnActivityByFamilyId(@PathVariable int familyId) {
        List<Activity> activityByUser = activityDao.getActivitiesByFamilyId(familyId);
        return activityByUser;
    }

    @RequestMapping(path = "/activity/minutes/{readerId}", method = RequestMethod.GET)
    public int returnTotalMinsByReaderId(@PathVariable int readerId) {
        int totalMins = activityDao.getTotalReadingMinutesByReaderId(readerId);
        return totalMins;
    }

}
