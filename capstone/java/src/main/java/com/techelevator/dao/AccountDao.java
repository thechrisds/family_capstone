package com.techelevator.dao;

public interface AccountDao {

    Boolean create(String familyName);

    void updateFamilyName(String familyName, int familyId);

    void deleteUser(int userId);

    void updateFamilyId(String parent, String username);

}
