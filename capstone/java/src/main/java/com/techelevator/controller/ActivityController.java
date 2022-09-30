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

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/activity/d/{activityId}", method = RequestMethod.DELETE)
    public void deleteActivity(@PathVariable int activityId){
        try {
            activityDao.deleteActivity(activityId);
        } catch (DataAccessException e){
            System.out.println("deletion failed.");
            }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/", method = RequestMethod.POST)
    public void createActivity(@RequestBody Activity activity) throws Exception {
        try {
            activityDao.createActivity(activity);
        } catch (DataAccessException e){
            throw new Exception("Adding activity failed!");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/user", method = RequestMethod.GET)
    public List<Activity> getActivitiesForCurrentUser(@RequestBody LoginDTO loginDTO) {
        int readerId = userDao.findIdByUsername(loginDTO.getUsername());
        List<Activity> activityList = activityDao.getActivitiesByCurrentUser(readerId);
        return activityList;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/family", method = RequestMethod.GET)
    public List<Activity> getActivitiesByFamilyId(Principal principal) {
        int familyId = userDao.findFamilyIdByUsername(principal.getName());
        List<Activity> activityList = activityDao.getActivitiesByFamilyId(familyId);
        return activityList;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity", method = RequestMethod.GET)
    public List<Activity> returnAllActivity() {
        List<Activity> activityList = activityDao.getAllReadingActivities();
        return activityList;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/{activityId}", method = RequestMethod.GET)
    public Activity returnActivityByActivityId(@PathVariable int activityId) {
        Activity activity = activityDao.getActivityByActivityId(activityId);
        return activity;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/rid/{readerId}", method = RequestMethod.GET)
    public List<Activity> returnActivityByReaderId(@PathVariable int readerId) {
        List<Activity> activityList = activityDao.getActivitiesByReaderId(readerId);
        return activityList;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/minutes/{readerId}", method = RequestMethod.GET)
    public int returnTotalMinsByReaderId(@PathVariable int readerId) {
        int totalMinutes = activityDao.getTotalReadingMinutesByReaderId(readerId);
        return totalMinutes;
    }

    private String getUserNameFromDTO(LoginDTO loginDTO) { return loginDTO.getUsername(); }
    private String getUserNameFromPrincipal(Principal principal){
        return principal.getName();
    }
}
