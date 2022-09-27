package com.techelevator.model;

public class Account {

    private int familyId;
    private String familyName;

    public Account(int familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
    }

    public Account() {
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString(){
        return "Family ID: "+this.familyId+"\n"+
                "Family Name: "+this.familyName+"\n";
    }
}
