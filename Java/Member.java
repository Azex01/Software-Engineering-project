package com.example.sweproject;

import java.util.ArrayList;

public class Member {

    private String email;
    private String name;
    private Team team;
    private ArrayList<String> researchInterest;

    // Constructor to create a member with a team
    public Member(String email, String name, Team team) {
        this.email = email;
        this.name = name;
        this.team = team;
    }

    // Constructor to create a member without a team
    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }
        public void addMember(String name, String emai,Team team){

        }
    // Method to view team details
    public ArrayList<ArrayList<String>> viewTeam() {
        ArrayList<ArrayList<String>> allTeamDetails = new ArrayList<>();

        // Adding project details to the team
        ArrayList<String> projectDetails = new ArrayList<>();
        projectDetails.add("Projects:");
        for (Project project : team.getProjects()) {
            projectDetails.add(" - " + project.getName());
        }

        // Adding admin details to the team
        ArrayList<String> admin = new ArrayList<>();
        admin.add("Admin:");
        admin.add(" - " + team.getAdmin().getName());

        // Adding member details
        ArrayList<String> membersDetails = new ArrayList<>();
        membersDetails.add("Members:");
        for (Member member : team.getMembers()) {
            membersDetails.add(" - " + member.getName());
        }

        // Compiling all details into one list
        allTeamDetails.add(projectDetails);
        allTeamDetails.add(admin);
        allTeamDetails.add(membersDetails);

        return allTeamDetails;
    }

    // Method to print team details
    public void TeamDString() {
        ArrayList<ArrayList<String>> TeamDetails = this.viewTeam();

        for (ArrayList<String> Detail : TeamDetails) {
            for (String detail : Detail) {
                System.out.println(detail);
            }
        }
    }

    // not compleeeeeete
    public ArrayList<ArrayList<String>> visualizeStats() {
        // implementation
        return new ArrayList<>();
    }

    // Setters and Getters
    public void setResearchInterest(ArrayList<String> researchInterest) {
        this.researchInterest = researchInterest;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}