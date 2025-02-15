package com.example.sweproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Machine {
    private String name;
    private String suggestedUsage;
    private List<Reservation> reservations;

    public Machine(String name, String suggestedUsage) {
        this.name = name;
        this.suggestedUsage = suggestedUsage;
        this.reservations = new ArrayList<>();
    }

    public boolean reserveMachine(int year, int month, int day, int hour, int minute, Team team) {
        for (Reservation reservation : reservations) {
            Calendar reservedTime = reservation.getDate();
            if (reservedTime.get(Calendar.YEAR) == year &&
                    reservedTime.get(Calendar.MONTH) == month &&
                    reservedTime.get(Calendar.DAY_OF_MONTH) == day &&
                    reservedTime.get(Calendar.HOUR_OF_DAY) == hour &&
                    reservedTime.get(Calendar.MINUTE) == minute) {
                // Time slot already reserved
                return false;
            }
        }

        // Time slot is available
        Reservation newReservation = new Reservation(year, month, day, hour, minute, team);
        reservations.add(newReservation);
        team.addMachine(this);
        return true;
    }

    public List<Integer> getAvailableHours(String date) {
        List<Integer> reservedHours = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getDateAsString().equals(date)) {
                reservedHours.add(reservation.getDate().get(Calendar.HOUR_OF_DAY));
            }
        }

        List<Integer> availableHours = new ArrayList<>();
        for (int hour = 0; hour < 24; hour++) {
            if (!reservedHours.contains(hour)) {
                availableHours.add(hour);
            }
        }

        return availableHours;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }


    public String visualizeUsage() {
        StringBuilder output = new StringBuilder();

        output.append("Machine '").append(name).append("' Usage Statistics:\n");
        output.append("Total Reservations: ").append(reservations.size()).append("\n");

        if (reservations.isEmpty()) {
            output.append("No reservations for this machine.\n");
        } else {
            output.append("Teams with active reservations:\n");

            List<String> activeTeams = new ArrayList<>();
            for (Reservation reservation : reservations) {
                String team = reservation.getTeam();
                if (!activeTeams.contains(team)) {
                    activeTeams.add(team);
                }
            }

            for (String team : activeTeams) {
                output.append("- ").append(team).append("\n");
            }
        }



        return output.toString();
    }

    public String getName() {
        return name;
    }
}