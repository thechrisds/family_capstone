package com.techelevator.dao;

import com.techelevator.model.Account;

public interface AccountDao {

    boolean create(String familyName);

    void updateFamilyName(String familyName);

    Account getUserByAccount(String username);

    Account getAllUsersByAccount(int familyId);

}
