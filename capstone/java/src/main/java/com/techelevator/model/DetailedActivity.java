package com.techelevator.model;

import java.util.Date;

public class DetailedActivity {

    private String userName;
    private String bookTitle;
    private Date dateRead;
    private int timeInMinutes;
    private boolean isComplete;
    private String activityNotes;

    public DetailedActivity(String userName, String bookTitle, Date dateRead, int timeInMinutes, boolean isComplete, String activityNotes) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.dateRead = dateRead;
        this.timeInMinutes = timeInMinutes;
        this.isComplete = isComplete;
        this.activityNotes = activityNotes;
    }

    public DetailedActivity(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Date getDateRead() {
        return dateRead;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getActivityNotes() {
        return activityNotes;
    }

    public void setActivityNotes(String activityNotes) {
        this.activityNotes = activityNotes;
    }

    @Override
    public String toString() {
        return "DetailedActivity{" +
                "userName='" + userName + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", dateRead=" + dateRead +
                ", timeInMinutes=" + timeInMinutes +
                ", isComplete=" + isComplete +
                ", activityNotes='" + activityNotes + '\'' +
                '}';
    }
}
