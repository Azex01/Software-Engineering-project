package com.example.sweproject;

import java.util.ArrayList;

public class Project {
    // Class variables
    private String name;
    private Team team;

    // Constructor to create a Project with a specified team
    public Project(String name, Team team) {
        this.name = name;
        this.team = team;
        team.addProject(this); // Automatically adds this project to the team
    }

    // Constructor to create a Project without a team
    public Project(String name) {
        this.name = name;
    }

    // Method to view project details including name, team, admin, and members
    public ArrayList<ArrayList<String>> viewProjectDetails() {
        ArrayList<ArrayList<String>> allProjectDetails = new ArrayList<>();

        // Adding project name
        ArrayList<String> project = new ArrayList<>();
        project.add("Project name:");
        project.add(" - " + this.getName());

        // Adding team name
        ArrayList<String> teamname = new ArrayList<>();
        teamname.add("Team name:");
        teamname.add(" - " + team.getName());

        // Adding admin details
        ArrayList<String> admin = new ArrayList<>();
        teamname.add("Admin:");
        teamname.add(" - " + team.getAdmin().getName());

        // Adding project members
        ArrayList<String> members = new ArrayList<>();
        members.add("Members:");
        for (Member member : team.getMembers()) {
            members.add(" - " + member.getName());
        }

        // Compiling all details
        allProjectDetails.add(project);
        allProjectDetails.add(teamname);
        allProjectDetails.add(admin);
        allProjectDetails.add(members);
        //// machine not complete

        return allProjectDetails;
    }

    // Method to print project details
    public void projectDString() {
        ArrayList<ArrayList<String>> projectDetails = this.viewProjectDetails();

        for (ArrayList<String> Detail : projectDetails) {
            for (String detail : Detail) {
                System.out.println(detail);
            }
        }
    }

    // Getter and Setter for project name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for team
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}