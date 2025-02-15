package com.example.sweproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reservation implements Comparable<Reservation> {

    private Calendar date;
    private Team team;


    public Reservation(int year, int month, int day, int hour, int minute, Team team) {
        validateDate(year, month, day, hour, minute);
        this.date = new GregorianCalendar(year, month, day, hour, minute);
        this.team = team;
    }

    private void validateDate(int year, int month, int day, int hour, int minute) {
        if (year < 0) {
            throw new IllegalArgumentException("Year must be a non-negative value");
        }

        if (month < 0 || month > 11) { // Month is zero based in Java Calendar
            throw new IllegalArgumentException("Month must be between 0 and 11");
        }

        int maxDay = new GregorianCalendar(year, month, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Day must be between 1 and " + maxDay + " for the given month");
        }

        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
    }


    public String print() {
        String time;
        int hourOfDay = date.get(Calendar.HOUR_OF_DAY);
        int minute = date.get(Calendar.MINUTE);

        time = String.format("%02d:%02d", hourOfDay, minute);

        return time;
    }


    public Calendar getDate() {
        return date;
    }

    public String getTeam() {
        return team.getName();
    }

    public String getDateAsString() {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) + 1; // Months are zero-based
        int day = date.get(Calendar.DAY_OF_MONTH);

        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public boolean occursOn(int year, int month, int day, int hour, int minute) {
        return date.get(Calendar.YEAR) == year &&
                date.get(Calendar.MONTH) == month &&
                date.get(Calendar.DAY_OF_MONTH) == day &&
                date.get(Calendar.HOUR_OF_DAY) == hour &&
                date.get(Calendar.MINUTE) == minute;
    }

    public boolean occursOn(int year, int month, int day) {
        return date.get(Calendar.YEAR) == year &&
                date.get(Calendar.MONTH) == month &&
                date.get(Calendar.DAY_OF_MONTH) == day;
    }

    public int compareTo(Reservation other) {
        return date.compareTo(other.date);
    }
}