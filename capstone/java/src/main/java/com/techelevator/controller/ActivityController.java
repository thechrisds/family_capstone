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
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    public ActivityController(ActivityDao activityDao, BookDao bookDao, UserDao userDao) {
        this.activityDao = activityDao;
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/activity/d/{activityId}", method = RequestMethod.DELETE)
    public void deleteActivity(@PathVariable int activityId){
        try {
            activityDao.deleteActivity(activityId);
        } catch (DataAccessException e){
            System.out.println("deletion failed.");
            }
    }

    @RequestMapping(path = "/activity/", method = RequestMethod.POST)
    public void createActivity(@RequestBody Activity activity) throws Exception {
        try {
            activityDao.createActivity(activity);
        } catch (DataAccessException e){
            throw new Exception("Adding activity failed!");
        }
    }

    @RequestMapping(path = "/activity/family", method = RequestMethod.GET)
    public List<Activity> getActivitiesByFamilyId(@RequestBody LoginDTO loginDTO) {
        int familyId = userDao.findFamilyIdByUsername(loginDTO.getUsername());
        List<Activity> activityByFamily = activityDao.getActivitiesByFamilyId(familyId);
        return activityByFamily;
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

    @RequestMapping(path = "/activity/minutes/{readerId}", method = RequestMethod.GET)
    public int returnTotalMinsByReaderId(@PathVariable int readerId) {
        int totalMins = activityDao.getTotalReadingMinutesByReaderId(readerId);
        return totalMins;
    }

    private String getUserNameFromDTO(LoginDTO loginDTO) { return loginDTO.getUsername(); }
    private String getUserNameFromPrincipal(Principal principal){
        return principal.getName();
    }
}
