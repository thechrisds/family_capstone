package com.techelevator.model;

import java.util.Date;

public class Activity {

    private int activityId;
    private int bookId;
    private int readerId;
    private Date dateRead;
    private int timeInMinutes;
    private String activityNotes;
    private boolean isComplete;

    public Activity(int activityId, int bookId, int readerId, Date dateRead, int timeInMinutes, String activityNotes, boolean isComplete) {
        this.activityId = activityId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.dateRead = dateRead;
        this.timeInMinutes = timeInMinutes;
        this.activityNotes = activityNotes;
        this.isComplete = isComplete;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
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

    public String getActivityNotes() {
        return activityNotes;
    }

    public void setActivityNotes(String activityNotes) {
        this.activityNotes = activityNotes;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", dateRead=" + dateRead +
                ", timeInMinutes=" + timeInMinutes +
                ", activityNotes='" + activityNotes + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }

    //TODO
}
