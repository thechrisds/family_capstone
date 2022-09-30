package com.techelevator.controller;
import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
