package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.Date;
import java.util.List;

public interface PrizeDao {


    List<Prize> findPrizesByFamilyId(int familyId); //grabs all prizes related to familyId

    boolean addPrize(int familyId, String name, String description, int goal, int stock, Date start_date, Date end_date);

    void updatePrize(Prize prize);

    //void deleteExpiredPrize(int prizeId); not needed, we can check if prize is expired by comparing end_date to current_date.
    //if prize is expired, we display it in an "expired" section/link/list/whatever

    List<Prize> findInactivePrizes(int familyId); //will grab all prizes where current_date > end_date relating to familyId

    void deletePrize(int prizeId); //different from deleteExpiredPrize--will have button on prize_info 'page' that allows you to delete a prize that has been added

    List<Prize> findActivePrizes(int familyId); //take the username from Principal, userDao.findFamilyIdByUsername for familyId
    //probably something like -- select * from prizes where current_date >= start_date and current_date <= end_date





}
