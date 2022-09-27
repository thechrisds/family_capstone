package com.techelevator.dao;

public interface AccountDao {

    void create(String familyName);

    void updateWhileCreate(String familyName);

    void updateFamilyName(String familyName, int familyId);

    void deleteUser(int userId);

    void updateFamilyId(String parent, String username);

}
