package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;

public class Activity {

    private int activityId;
    private int readerId;
    private long isbn;
    private String format;
    private Date dateRead;
    private int timeInMinutes;
    private String activityNotes;
    private boolean isComplete;

    public Activity(int activityId, int readerId, long isbn, String format, Date dateRead, int timeInMinutes, String activityNotes,  boolean isComplete) {
        this.activityId = activityId;
        this.readerId = readerId;
        this.isbn = isbn;
        this.format = format;
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

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
                ", readerId=" + readerId +
                ", isbn=" + isbn +
                ", format='" + format + '\'' +
                ", dateRead=" + dateRead +
                ", timeInMinutes=" + timeInMinutes +
                ", activityNotes='" + activityNotes + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
    //TODO
}