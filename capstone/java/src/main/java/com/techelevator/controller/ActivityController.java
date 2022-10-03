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
    public void createActivity(@RequestBody Activity activity, Principal principal) throws Exception {
       // int userId = userDao.findIdByUsername(principal.getName());
        //activity.setReaderId(userId);
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
        return activityDao.getActivitiesByCurrentUser(readerId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/family", method = RequestMethod.GET)
    public List<Activity> getActivitiesByFamilyId(Principal principal) {
        int familyId = userDao.findFamilyIdByUsername(principal.getName());
        return activityDao.getActivitiesByFamilyId(familyId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity", method = RequestMethod.GET)
    public List<Activity> returnAllActivity() {
        return activityDao.getAllReadingActivities();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/minutes", method = RequestMethod.GET)
    public int returnFamilyMinutes(Principal principal) {
        int familyId = userDao.findFamilyIdByUsername(principal.getName());
        return activityDao.getTotalReadingMinutesByFamily(familyId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/{activityId}", method = RequestMethod.GET)
    public Activity returnActivityByActivityId(@PathVariable int activityId) {
        return activityDao.getActivityByActivityId(activityId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/rid/{readerId}", method = RequestMethod.GET)
    public List<Activity> returnActivityByReaderId(@PathVariable int readerId) {
        return activityDao.getActivitiesByReaderId(readerId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/activity/minutes/{readerId}", method = RequestMethod.GET)
    public int returnTotalMinsByReaderId(@PathVariable int readerId) {
        return activityDao.getTotalReadingMinutesByReaderId(readerId);
    }

    private String getUserNameFromDTO(LoginDTO loginDTO) { return loginDTO.getUsername(); }
    private String getUserNameFromPrincipal(Principal principal){
        return principal.getName();
    }
}
