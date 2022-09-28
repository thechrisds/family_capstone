package com.techelevator.model;

import java.util.Date;

public class Activity {

    private int activityId;
    private long isbn;
    private int readerId;
    private Date dateRead;
    private int timeInMinutes;
    private String activityNotes;
    private boolean isComplete;
    private String format;

    public Activity(int activityId, long isbn, int readerId, Date dateRead, int timeInMinutes, String activityNotes, boolean isComplete, String format) {
        this.activityId = activityId;
        this.isbn = isbn;
        this.readerId = readerId;
        this.dateRead = dateRead;
        this.timeInMinutes = timeInMinutes;
        this.activityNotes = activityNotes;
        this.isComplete = isComplete;
        this.format = format;
    }

    public Activity(){}

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public long getBookId() {
        return isbn;
    }

    public void setBookId(long isbn) {
        this.isbn = isbn;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", isbn=" + isbn +
                ", readerId=" + readerId +
                ", dateRead=" + dateRead +
                ", timeInMinutes=" + timeInMinutes +
                ", activityNotes='" + activityNotes + '\'' +
                ", isComplete=" + isComplete +
                ", format='" + format + '\'' +
                '}';
    }

//TODO
}
