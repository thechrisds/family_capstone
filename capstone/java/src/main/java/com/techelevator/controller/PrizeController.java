package com.techelevator.controller;
import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PrizeController {

    @Autowired
    private PrizeDao prizeDao;
    @Autowired
    private UserDao userDao;

    public PrizeController(PrizeDao prizeDao){
        this.prizeDao = prizeDao;
    }

    @RequestMapping(value = "/prizes", method = RequestMethod.GET)
    public List<Prize> getPrizes(Principal principal){
        List<Prize> prizeList = new ArrayList<>();
        return prizeList = prizeDao.findPrizesByFamilyId(userDao.findFamilyIdByUsername(principal.getName()));
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/prizes", method = RequestMethod.POST)
    public void addPrize(@RequestBody Prize prize, Principal principal) throws Exception {
        prize.setFamily_id(userDao.findFamilyIdByUsername(principal.getName()));
        if (!prizeDao.addPrize(prize.getFamily_id(), prize.getName(), prize.getDescription(), prize.getGoal(), prize.getStock(), prize.getStart_date(), prize.getEnd_date())){
            throw new Exception("Adding prize failed");
        }

    }

}
